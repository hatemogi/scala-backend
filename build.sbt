version := "0.1"

scalaVersion := "2.13.1"

lazy val root = (project in file("."))
  .settings(
    name := "scala-backend",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % Test
  )