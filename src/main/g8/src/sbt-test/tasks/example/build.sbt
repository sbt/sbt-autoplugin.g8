scalaVersion := "$scalaVersion$"

TaskKey[Unit]("check") := {
  val example = exampleTask.value
  streams.value.log.info(example)
}
