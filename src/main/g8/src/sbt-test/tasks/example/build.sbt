scalaVersion := "$scalaVersion$"

TaskKey[Unit]("check") := {
  val example = (Compile / $pluginName;format="camel"$ExampleTask).value
  streams.value.log.info(example)
}
