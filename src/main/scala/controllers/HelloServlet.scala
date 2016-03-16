package controllers

import org.scalatra.ScalatraServlet
import org.scalatra.scalate.ScalateSupport
import org.slf4j.LoggerFactory

/**
 * @author VKoulakov
 * @since 14.03.2016 19:05
 */
class HelloServlet extends ScalatraServlet with ScalateSupport{
  val logger =  LoggerFactory.getLogger(getClass)
  get("/"){
/*
    <html>
      <body>
        <h1>Hello, world!!!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
*/
    contentType = "text/html;charset=UTF-8"
    scaml("/hello-scalate.scaml")
  }
  notFound {
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }

}
