name := """$name;format="norm"$"""
description := """$purpose$"""
organization := "$organization$"
organizationName := "$organizationName$"

sbtPlugin := true
publishMavenStyle := false

libraryDependencies += "com.lihaoyi" %% "utest" % "$uTestVersion$" % Test
testFrameworks += new TestFramework("utest.runner.Framework")

bintrayPackageLabels := Seq("sbt", "plugin")
bintrayVcsUrl := Some("""git@github.com:$organizationName;format="word"$/$name;format="norm"$.git""")

initialCommands in console := """import $package$._"""

enablePlugins(ScriptedPlugin)
scriptedLaunchOpts ++= Seq(
  "-Xmx1024M",
  "-Dplugin.version=" + version.value
)
