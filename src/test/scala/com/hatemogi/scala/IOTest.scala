package com.hatemogi.scala

import cats.effect.IO
import org.scalatest.funsuite.AnyFunSuite
import scala.io.StdIn.readLine

class IOTest extends AnyFunSuite {
  test("basic IO") {
    val io = IO {
      println("hello")
    }
    val read = IO {
      readLine()
    }
    io.flatMap(_ => read).unsafeRunSync()
  }

}
