package util

import domain.{Product, Catalogue}
import org.slf4j.Logger
import org.squeryl.PrimitiveTypeMode._

/**
 * @author VKoulakov
 * @since 17.03.2016 16:07
 */
trait DatabaseInititalizer {
  def initDb(implicit logger: Logger) {
    logger.info("Applying database schema")
    transaction {
      Catalogue.printDdl
      Catalogue.create
      Catalogue.products.insert(List(
        new Product(1, "Test1", "TT00001"),
        new Product(2, "Test2", "TT00002"),
        new Product(3, "Test3", "TT00003")
      ))
    }
  }
}
