import org.scalactic.Requirements._
import org.scalactic.TripleEquals._

scalaVersion := "$scalaVersion$"

TaskKey[Unit]("check") := {
  val example = (Compile / $pluginName;format="camel"$ExampleTask).value
  require(example === "computed from example setting: just an example")
}
