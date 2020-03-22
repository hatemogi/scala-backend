package com.hatemogi.scala

import com.twitter.finagle.{Http, Service, http}
import com.twitter.io.Buf
import com.twitter.util.{Await, Future}

object Main extends App {
  def factorial(n: Int): Int =
    (1 to n).product

  println("factorial(5) = " + factorial(5))

  val service: Service[http.Request, http.Response] = { req =>
    val res = http.Response(req.version, http.Status.Ok)
    res.content(Buf.Utf8("안녕하세요"))
    res.setContentType("text/plain", "UTF-8")
    Future.value(res)
  }

  val server = Http.serve(":8080", service)
  Await.ready(server)
}
