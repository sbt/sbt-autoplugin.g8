package $package$

import $package$.$pluginName;format="Camel"$Settings._
import sbt._
import sbt.plugins.JvmPlugin

object $pluginName;format="Camel"$Plugin extends AutoPlugin {

  override def trigger = allRequirements
  override def requires = JvmPlugin

  object autoImport extends $pluginName;format="Camel"$Keys

  override lazy val projectSettings: Seq[Def.Setting[_]] = {
    inConfig(Compile)(rawSettings)
  }
}
