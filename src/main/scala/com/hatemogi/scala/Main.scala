package com.hatemogi.scala

import com.twitter.finagle.{Http, Service, http}
import com.twitter.io.Buf
import com.twitter.util.{Await, Future}

object Main extends App {
  def factorial(n: Int): Int =
    (1 to n).product

  println("factorial(5) = " + factorial(5))

  val service = new Service[http.Request, http.Response] {
    def apply(req: http.Request): Future[http.Response] =
      Future.value(
        http.Response(http.Version.Http11, http.Status.Ok)
          .content(Buf.Utf8("Hello"))
    )
  }

  val server = Http.serve(":8080", service)
  Await.ready(server)
}
