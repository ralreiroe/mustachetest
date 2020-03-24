
scalaVersion := "2.12.10"


val akkaVersion           = "2.6.3"
val akkaHttpVersion       = "10.1.11"
val typesafeConfigVersion = "1.3.3"
val log4j2Version         = "2.11.1"
val alpakkaVersion        = "1.1.2"


name := "hello-world"
organization := "ch.epfl.scala"
version := "1.0"

libraryDependencies ++= Seq(
  "javax.json"               % "javax.json-api"            % "1.1.4",
  "org.slf4j"                % "slf4j-api"                 % "1.7.25",
  "org.apache.logging.log4j" % "log4j-api"                 % log4j2Version,
  "org.apache.logging.log4j" % "log4j-core"                % log4j2Version % Runtime,
  "org.apache.logging.log4j" % "log4j-slf4j-impl"          % log4j2Version,
  "com.typesafe"             % "config"                    % typesafeConfigVersion,
  "com.typesafe.play"        %% "play-json"                % "2.8.1",
  "org.trimou"               % "trimou-core"               % "2.5.0.Final",
  "org.trimou"               % "trimou-extension-gson"     % "2.5.0.Final",
//  "org.trimou"               % "trimou-extension-json-p"   % "2.5.0.Final",
  "javax.json.bind" % "javax.json.bind-api" % "1.0",
  "org.eclipse" % "yasson" % "1.0.3",
  "org.scalatest"            %% "scalatest"                % "3.1.0" % Test,
  "org.scalamock"            %% "scalamock"                % "4.4.0" % Test,
  "org.scalacheck"           %% "scalacheck"               % "1.14.3" % Test,
  "org.scalatestplus"        %% "scalatestplus-scalacheck" % "3.1.0.0-RC2" % Test,
)