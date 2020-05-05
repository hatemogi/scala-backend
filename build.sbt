version := "0.1"

scalaVersion := "2.13.2"

val http4sVersion = "0.21.2"
val circeVersion = "0.13.0"
val catsVersion = "2.0.0"
val fs2Version = "2.2.1"

val http4sDependencies = Seq(
  "org.http4s" %% "http4s-dsl",
  "org.http4s" %% "http4s-blaze-server",
  "org.http4s" %% "http4s-blaze-client",
  "org.http4s" %% "http4s-circe"
).map(_ % http4sVersion)

val jsonDependencies = Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

val catsDependencies = Seq(
  "org.typelevel" %% "cats-core",
  "org.typelevel" %% "cats-effect",
).map(_ % catsVersion)

val fs2Dependencies = Seq(
  "co.fs2" %% "fs2-core",
  "co.fs2" %% "fs2-io"
).map(_ % fs2Version)

lazy val root = (project in file("."))
  .settings(
    name := "scala-backend",
    libraryDependencies ++= Seq(
      "ch.qos.logback" % "logback-classic" % "1.2.3",
      "org.scalatest" %% "scalatest" % "3.1.1" % Test,
      "org.scalatestplus" %% "scalacheck-1-14" % "3.1.1.1" % Test,
      "org.scalacheck" %% "scalacheck" % "1.14.1" % Test
    ) ++ http4sDependencies ++ jsonDependencies ++ catsDependencies ++ fs2Dependencies
  )