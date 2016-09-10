sbtPlugin := true
organization := "name.de-vries"
name := "sbt-typescript"
version := "0.3.0-beta.3"

homepage := Some(url("https://github.com/joost-de-vries/sbt-typescript"))
licenses +=("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

scalaVersion := "2.10.6"
javacOptions ++= Seq(
  "-source", "1.7",
  "-target", "1.7"
)
scalacOptions ++= Seq(
  "-feature",
  "-encoding", "UTF8",
  "-deprecation",
  "-unchecked",
  "-target:jvm-1.7",
  "-Xlint",
  "-Ywarn-dead-code",
  "-Ywarn-adapted-args"
)
libraryDependencies ++= Seq(
  "org.webjars.npm" % "typescript" % "2.0.2",
  "org.webjars.npm" % "minimatch" % "3.0.0",
  "org.webjars.npm" % "fs-extra" % "0.26.6",
  "org.webjars.npm" % "es6-shim" % "0.35.1",
  "org.webjars" % "npm" % "3.9.3"
)

resolvers ++= Seq(
  Resolver.typesafeRepo("releases"),
  Resolver.sbtPluginRepo("releases"),
  Resolver.sonatypeRepo("releases"),
  Resolver.mavenLocal
)

addSbtPlugin("com.typesafe.sbt" % "sbt-js-engine" % "1.1.4")
addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.4.0")

publishMavenStyle := false
bintrayRepository in bintray := "sbt-plugins"
bintrayOrganization in bintray := None
bintrayVcsUrl := Some("git@github.com:joost-de-vries/sbt-typescript.git")

scriptedSettings
scriptedLaunchOpts <+= version apply { v => s"-Dproject.version=$v" }
