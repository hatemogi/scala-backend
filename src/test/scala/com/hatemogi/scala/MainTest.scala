package com.hatemogi.scala

import org.scalatest.funsuite.AnyFunSuite

class MainTest extends AnyFunSuite {
  test("factorial(5)") {
    assert(Main.factorial(5) == 120)
  }
}
