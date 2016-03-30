sbtPlugin := true

name := "sbt-spark-plugin"

scalaVersion := "2.10.4"

version := "1.1.1"

crossScalaVersions := Seq("2.10.4")

organization := "com.github.crakjie"

description := "A simple Sbt plugin used to fill spark-submit jar list"

licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html"))

import bintray.Keys._

publishMavenStyle := false

repository in bintray := "sbt-plugins"

bintrayOrganization in bintray := None
 
resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases"

resolvers += "JCenter" at "http://jcenter.bintray.com/"

libraryDependencies += "org.clapper" %% "grizzled-scala" % "1.3"
 
seq(bintrayPublishSettings:_*)