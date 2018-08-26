package $package$

import sbt._

trait $pluginName;format="Camel"$Keys {

  val $pluginName;format="camel"$ExampleSetting = settingKey[String]("A setting that is automatically imported to the build")
  val $pluginName;format="camel"$ExampleTask = taskKey[String]("A task that is automatically imported to the build")
}

object $pluginName;format="Camel"$Keys extends $pluginName;format="Camel"$Keys
