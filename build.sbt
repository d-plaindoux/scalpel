import sbt.Keys.libraryDependencies

val scala3Version = "3.5.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "Scalpel",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.19" % "test",
      "org.scalacheck" %% "scalacheck" % "1.18.1" % "test"
    )
  )
