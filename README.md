A [Giter8][g8] template to create an [sbt AutoPlugin](http://www.scala-sbt.org/0.13/docs/Plugins.html#Creating+an+auto+plugin).
AutoPlugins are the recommended way to create sbt plugins for sbt versions 0.13.5 and up.

# Usage

1. [Install sbt 0.13.13 or higher](http://www.scala-sbt.org/release/docs/Setup.html)
2. On the command line type:

    sbt new sbt/sbt-autoplugin.g8
3. You will be prompted for a few basic settings for your project
4. sbt will create a plugin project for you.

This template includes the scripted-plugin for [testing sbt plugins](http://www.scala-sbt.org/0.13/docs/Testing-sbt-plugins.html)


Template license
----------------
Written in 2017 by Justin Kaeser <justin@github.mesh.works>

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
