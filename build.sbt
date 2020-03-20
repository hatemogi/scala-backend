version := "0.1"

scalaVersion := "2.13.1"

lazy val root = (project in file("."))
  .settings(
    name := "scala-backend",
    libraryDependencies ++= Seq(
      "com.twitter" %% "finagle-http" % "20.3.0",
      "ch.qos.logback" % "logback-classic" % "1.2.3",
      "org.scalatest" %% "scalatest" % "3.1.1" % Test
    )
  )