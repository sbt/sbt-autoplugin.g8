package $package$

import $package$.$pluginName;format="Camel"$Keys._
import sbt._

object $pluginName;format="Camel"$Tasks {

  def exampleTask = Def.task {
    "computed from example setting: " + $pluginName;format="camel"$ExampleSetting.value
  }
}
