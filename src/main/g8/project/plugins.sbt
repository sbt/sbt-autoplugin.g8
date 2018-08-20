libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value

addSbtPlugin("org.foundweekends" % "sbt-bintray" % $bintrayVersion$)

addSbtPlugin("com.dwijnand" % "sbt-dynver" % $dynverVersion$)

