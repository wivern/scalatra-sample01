import javax.servlet.ServletContext

import com.mchange.v2.c3p0.ComboPooledDataSource
import controllers.HelloServlet
import org.scalatra.LifeCycle
import org.slf4j.LoggerFactory
import org.squeryl.Session
import org.squeryl.SessionFactory
import org.squeryl.adapters.H2Adapter
import util.DatabaseInititalizer

/**
 * @author VKoulakov
 * @since 14.03.2016 17:28
 */
class ScalatraBootstrap extends LifeCycle with DatabaseInititalizer {
  val logger = LoggerFactory.getLogger(getClass)

  val cpds = new ComboPooledDataSource

  override def init(context: ServletContext) {
    context mount(new HelloServlet, "/*")
    SessionFactory.concreteFactory = Some(() => connection)

    def connection = {
      logger.info("Creating connection with c3po connection pool")
      Session.create(cpds.getConnection, new H2Adapter)
    }
    initDb(logger)
  }

  private def closeDbConnection() {
    logger.info("Closing c3po connection pool")
  }

  override def destroy(context: ServletContext) {
    super.destroy(context)
    closeDbConnection()
  }
}
