// The simplest possible sbt build file is just one line:

scalaVersion := "2.13.1"
// That is, to create a valid sbt build, all you've got to do is define the
// version of Scala you'd like your project to use.

// ============================================================================

// Lines like the above defining `scalaVersion` are called "settings". Settings
// are key/value pairs. In the case of `scalaVersion`, the key is "scalaVersion"
// and the value is "2.13.1"

// It's possible to define many kinds of settings, such as:

name := "hello-world"
organization := "ch.epfl.scala"
version := "1.0"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "2.0.0",
  "com.typesafe.play"        %% "play-json"                % "2.8.1",
  "org.trimou"               % "trimou-core"               % "2.5.0.Final",
  "org.trimou"               % "trimou-extension-gson"     % "2.5.0.Final",
  "javax.json"               % "javax.json-api"     % "1.1.4",
  "org.trimou"               % "trimou-extension-json-p"   % "2.5.0.Final"
)
