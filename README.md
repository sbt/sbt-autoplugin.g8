# sbt-autoplugin.g8

[![Build Status]](https://travis-ci.org/BotTech/sbt-autoplugin)

A [Giter8][g8] template to create an [sbt AutoPlugin].

AutoPlugins are the recommended way to create sbt plugins for sbt versions 0.13.5 and up. This template creates a plugin
for sbt 1.x

The original [sbt/sbt-autoplugin.g8][Original Repo] template was intended to contain the minimum amount to get started.
This fork is more comprehensive and opinionated, with the aim of requiring the minimum amount of configuration to get
the plugin published.

## Plugins

The generated project uses the following sbt plugins:
* [sbt-bintray] - publishes releases to [Bintray].
* [sbt-dynver] - dynamically determines version numbers from git tags.
* [sbt-github-release] - publishes releases to [GitHub].

## Usage

1. [Install sbt 1.0.0 or higher][sbt Setup]
1. On the command line type:
   ```bash
   sbt new BotTech/sbt-autoplugin.g8
   ```
1. You will be prompted for a few basic settings for your project.
1. sbt will create a plugin project for you.
1. Follow the instructions in `SETUP.md`.

## Credits

Special thanks to:
* [GitHub] for hosting the git repository.
* [Lightbend] for [Scala] and [sbt].
* [scalacenter] for [Scala].
* [Travis CI] for running the build.
* All the other OSS contributors who made this project possible.

[Bintray]: https://bintray.com
[Build Status]: https://travis-ci.org/BotTech/sbt-gpg.svg?branch=master
[g8]: http://www.foundweekends.org/giter8
[Github]: https://github.com
[Lightbend]: https://www.lightbend.com
[Original Repo]: https://github.com/sbt/sbt-autoplugin.g8
[sbt]: https://www.scala-sbt.org
[sbt AutoPlugin]: http://www.scala-sbt.org/1.x/docs/Plugins.html#Creating+an+auto+plugin
[sbt Setup]: http://www.scala-sbt.org/release/docs/Setup.html
[sbt-bintray]: https://github.com/sbt/sbt-bintray
[sbt-dynver]: https://github.com/dwijnand/sbt-dynver
[sbt-github-release]: https://github.com/ohnosequences/sbt-github-release
[Scala]: https://www.scala-lang.org
[scalacenter]: https://scala.epfl.ch
[Travis CI]: https://travis-ci.org
