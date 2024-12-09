Global / excludeLintKeys += idePackagePrefix

lazy val root = (project in file("."))
  .settings(
    organization     := "com.martinbrosenberg",
    idePackagePrefix := Some("com.martinbrosenberg.adventofcode"),
    name             := "AdventOfCode",
    version          := "0.0.1-SNAPSHOT",
    scalaVersion     := "3.5.2",
    libraryDependencies ++= Seq(
      "org.scalactic"       %% "scalactic"    % "3.2.19",
      "com.github.dwickern" %% "scala-nameof" % "4.0.0"  % "provided",
      "org.scalacheck"      %% "scalacheck"   % "1.18.1" % "test",
      "org.scalatest"       %% "scalatest"    % "3.2.19" % "test"
    ),
    testFrameworks += TestFrameworks.ScalaTest
  )
