enablePlugins(ScriptedPlugin)

name := "sbt-autoplugin.g8"

test in Test := {
  val _ = (g8Test in Test).toTask("").value
}

lazy val g8TestDirectory = settingKey[File]("The directory containing the g8 test.")
g8TestDirectory := (Test / sourceDirectory).value / "g8"
Compile / g8 / unmanagedSourceDirectories += g8TestDirectory.value
Compile / g8 / sources ++= {
  val dir = g8TestDirectory.value
  sbt.Path.allSubpaths(dir).collect {
    case (f, _) if f.isFile => f
  }.toSeq
}
