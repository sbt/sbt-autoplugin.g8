name := """$name;format="norm"$"""
description := """$purpose$"""
organization := "$organization$"
organizationName := "$organizationName$"
licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html"))

sbtPlugin := true
publishMavenStyle := false

libraryDependencies += "com.lihaoyi" %% "utest" % "$uTestVersion$" % Test
testFrameworks += new TestFramework("utest.runner.Framework")

bintrayPackageLabels := Seq("sbt", "plugin")
bintrayVcsUrl := Some("""git@github.com:$organizationName;format="word"$/$name;format="norm"$.git""")
bintrayRepository := "sbt-plugins"
bintrayOrganization := Some("$organizationName;format="lower"$")

initialCommands in console := """import $package$._"""

enablePlugins(ScriptedPlugin)
scriptedLaunchOpts ++= Seq(
  "-Xmx1024M",
  "-Dplugin.version=" + version.value
)
