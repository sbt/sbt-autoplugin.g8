name := "$name;format="norm"$"
description := """$purpose$"""
organization := "$organization$"
organizationName := "$organizationName$"
homepage := Some(url("https://github.com/$organizationName;format="word"$/$name;format="norm"$"))
licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html"))

scalaVersion := "$scalaVersion$"

sbtPlugin := true

libraryDependencies += "com.lihaoyi" %% "utest" % "$uTestVersion$" % Test
testFrameworks += new TestFramework("utest.runner.Framework")

enablePlugins(ScriptedPlugin)
scriptedLaunchOpts ++= Seq(
  "-Xmx1024M",
  "-Dplugin.version=" + version.value
)

publishMavenStyle := false

bintrayOrganization := Some("$organizationName;format="lower"$")
bintrayPackageLabels := Seq("sbt", "plugin")

ghreleaseRepoOrg := organizationName.value
