package domain

import org.squeryl.KeyedEntity

/**
 * @author VKoulakov
 * @since 17.03.2016 15:31
 */
case class Category(id: Long,
                     name: String) extends KeyedEntity[Long]{
   lazy val products = Catalogue.productCategories.right(this)
}
