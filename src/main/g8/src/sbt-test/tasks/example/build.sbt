import org.scalactic.Requirements._
import org.scalactic.TripleEquals._

scalaVersion := "$scalaVersion$"

TaskKey[Unit]("check") := {
  val log = state.value.log
  log.info("checking example setting")
  val example = (Compile / $pluginName;format="camel"$ExampleTask).value
  require(example === "computed from example setting: just an example")
}
