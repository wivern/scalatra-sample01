package controllers

import org.scalatra.ScalatraServlet
import org.scalatra.scalate.ScalateSupport
import org.slf4j.LoggerFactory
import util.DatabaseSessionSupport

/**
 * @author VKoulakov
 * @since 17.03.2016 18:52
 */
class AdminServlet extends ScalatraServlet with ScalateSupport with DatabaseSessionSupport{
  val logger =  LoggerFactory.getLogger(getClass)

  before(){
  }

  get("/"){
    contentType = "text/html;charset=UTF-8"
    scaml("/admin/index.scaml", "layout" -> "/WEB-INF/layouts/admin.scaml")
  }
}
