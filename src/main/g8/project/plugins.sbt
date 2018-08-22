libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value

addSbtPlugin("org.foundweekends" % "sbt-bintray" % "$bintrayVersion$")

addSbtPlugin("ohnosequences" % "sbt-github-release" % "$githubReleaseVersion$")

addSbtPlugin("com.dwijnand" % "sbt-dynver" % "$dynverVersion$")

addSbtPlugin("com.jsuereth" % "sbt-pgp" % "$pgpVersion$")
