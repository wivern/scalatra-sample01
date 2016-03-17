package controllers

import domain.{Product, Catalogue}
import org.scalatra.ScalatraServlet
import org.scalatra.scalate.ScalateSupport
import org.slf4j.LoggerFactory
import util.DatabaseSessionSupport

/**
 * @author VKoulakov
 * @since 14.03.2016 19:05
 */
class HelloServlet extends ScalatraServlet with ScalateSupport with DatabaseSessionSupport{
  val logger =  LoggerFactory.getLogger(getClass)
  get("/"){
    contentType = "text/html;charset=UTF-8"
    val products = Product.all.toList
    scaml("/index.scaml", "products" -> products)
  }
  get("/hello"){
    <html>
      <body>
        <h1>Hello, world!!!! Do it with DCEVM</h1>
      </body>
    </html>
  }
  notFound {
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }

}
