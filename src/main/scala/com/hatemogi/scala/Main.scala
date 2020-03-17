package com.hatemogi.scala

object Main extends App {
  def factorial(n: Int): Int =
    (1 to n).product

  println("factorial(5) = " + factorial(5))
}
