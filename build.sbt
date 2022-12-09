lazy val root = (project in file("."))
  .settings(
    organization := "com.martinbrosenberg",
    idePackagePrefix := Some("com.martinbrosenberg.adventofcode"),
    name := "ScalaExercises",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "3.2.1",
    libraryDependencies ++= Seq(
      "com.github.dwickern" %% "scala-nameof" % "4.0.0"  % "provided",
      "org.scalacheck"      %% "scalacheck"   % "1.17.0" % "test",
      "org.scalatest"       %% "scalatest"    % "3.2.14" % "test",
    ),
    testFrameworks += TestFrameworks.ScalaTest
  )
