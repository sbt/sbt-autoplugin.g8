# sbt-autoplugin.g8

[![Build Status][Build Status]](https://travis-ci.org/BotTech/sbt-cached-updates)

A [Giter8][g8] template to create an [sbt AutoPlugin][sbt AutoPlugin].

AutoPlugins are the recommended way to create sbt plugins for sbt versions 0.13.5 and up. This template creates a plugin
for sbt 1.x

The original [sbt/sbt-autoplugin.g8][Original Repo] template was intended to contain the minimum amount to get started.
This fork is more comprehensive and opinionated, with the aim of requiring the minimum amount of configuration to get
the plugin published.

## Plugins

The generated project uses the following sbt plugins:
* [sbt-dynver][sbt-dynver] - dynamically determines version numbers from git tags.
* [sbt-bintray][sbt-bintray] - publishes releases to Bintray.
* [sbt-github-release][sbt-github-release] - publishes releases to GitHub.

## Usage

1. [Install sbt 1.0.0 or higher][sbt Setup]
1. On the command line type:
   ```bash
   sbt new BotTech/sbt-autoplugin.g8
   ```
1. You will be prompted for a few basic settings for your project.
1. sbt will create a plugin project for you.
1. Take a look at the project README.md.

## Credits

Special thanks to:
* [GitHub][Github] for hosting the git repository.
* [Travis CI][Travis CI] for running the build.
* All the other OSS contributors who made this project possible.

[Build Status]: https://travis-ci.org/BotTech/sbt-gpg.svg?branch=master
[g8]: http://www.foundweekends.org/giter8
[Github]: https://github.com
[Original Repo]: https://github.com/sbt/sbt-autoplugin.g8
[sbt AutoPlugin]: http://www.scala-sbt.org/1.x/docs/Plugins.html#Creating+an+auto+plugin
[sbt Setup]: http://www.scala-sbt.org/release/docs/Setup.html
[sbt-bintray]: https://github.com/sbt/sbt-bintray
[sbt-dynver]: https://github.com/dwijnand/sbt-dynver
[sbt-github-release]: https://github.com/ohnosequences/sbt-github-release
[sbt-pgp]: https://github.com/sbt/sbt-pgp
[Testing Plugins]: http://www.scala-sbt.org/0.13/docs/Testing-sbt-plugins.html
[Travis CI]: https://travis-ci.org
