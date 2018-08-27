package $package$

import $package$.$pluginName;format="Camel"$Keys._
import $package$.$pluginName;format="Camel"$Tasks._
import sbt._

object $pluginName;format="Camel"$Settings {

  val rawSettings = Seq(
    $pluginName;format="camel"$ExampleSetting := exampleSetting.value,
    $pluginName;format="camel"$ExampleTask := exampleTask.value
  )

  def exampleSetting = Def.setting {
    "just an example"
  }
}
