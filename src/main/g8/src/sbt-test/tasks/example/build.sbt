scalaVersion := "$scalaVersion$"

TaskKey[Unit]("check") := {
  val example = (Compile / exampleTask).value
  streams.value.log.info(example)
}
