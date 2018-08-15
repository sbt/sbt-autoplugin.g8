name := """$name;format="norm"$"""
organization := "$organization$"
organizationName := "$organizationName$"
version := "0.1-SNAPSHOT"

sbtPlugin := true

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
