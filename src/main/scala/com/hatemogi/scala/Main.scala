package com.hatemogi.scala

import cats.data.Kleisli
import cats.effect._
import cats.implicits._
import io.chrisdavenport.vault.Key
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.server.Router
import org.http4s.server.blaze._

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App {
  def factorial(n: Int): Int =
    (1 to n).product

  println("factorial(5) = " + factorial(5))

  implicit val cs: ContextShift[IO] = IO.contextShift(global)
  implicit val timer: Timer[IO] = IO.timer(global)

  val helloWorldService = HttpRoutes.of[IO] {
    case GET -> Root / "hello" / name =>
      Ok(s"안녕하세요, $name.")
  }

  val reqIdKey = Key.newKey[IO, String].unsafeRunSync()

  def requestIdSetter(service: HttpRoutes[IO]): HttpRoutes[IO] = Kleisli { req: Request[IO] =>
    val reqId = java.util.UUID.randomUUID().toString
    service(req.withAttribute(reqIdKey, reqId)).map { res: Response[IO] =>
      res.putHeaders(Header("X-Request-Id", reqId))
    }
  }

  val httpApp = requestIdSetter(
    Router("/" -> helloWorldService)
  ).orNotFound

  val server = BlazeServerBuilder[IO]
    .bindHttp(8080, "localhost")
    .withHttpApp(httpApp)
    .serve
    .compile
    .drain
    .as(ExitCode.Success)

  server.unsafeRunSync()
}
