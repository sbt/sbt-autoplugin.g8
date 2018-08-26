package $package$

import sbt._

trait $pluginName;format="Camel"$Keys {

  val exampleSetting = settingKey[String]("A setting that is automatically imported to the build")
  val exampleTask = taskKey[String]("A task that is automatically imported to the build")
}

object $pluginName;format="Camel"$Keys extends $pluginName;format="Camel"$Keys
