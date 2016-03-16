import javax.servlet.ServletContext

import controllers.HelloServlet
import org.scalatra.LifeCycle

/**
 * @author VKoulakov
 * @since 14.03.2016 17:28
 */
class ScalatraBootstrap extends LifeCycle{
  override def init(context: ServletContext) {
    context mount (new HelloServlet, "/*")
  }
}
