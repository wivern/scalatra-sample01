package util

import domain.{User, Product, Catalogue}
import org.slf4j.Logger
import org.squeryl.PrimitiveTypeMode._

/**
 * @author VKoulakov
 * @since 17.03.2016 16:07
 */
trait DatabaseInititalizer {
  implicit val logger: Logger
  def initDb() {
    logger.info("Applying database schema")
    transaction {
      Catalogue.printDdl
      Catalogue.create
      Catalogue.products.insert(List(
        new Product(1, "Test1", "TT00001"),
        new Product(2, "Test2", "TT00002"),
        new Product(3, "Test3", "TT00003")
      ))
      Catalogue.users.insert(List(
        new User(1, "admin", "admin@gmail.com", "admin"),
        new User(2, "John Doe", "user@gmail.com", "user")
      ))
    }
  }
}
