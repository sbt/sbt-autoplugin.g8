---
name: Bug report
about: Create a report to help us improve
labels: 

---

**WARNING**: Please do not attach any real secret keys or passphrases. Create a new key and passphrase if applicable.

**Description**
A clear and concise description of what the bug is.

**Versions**

Component | Version
------------ | -------
OS | 10.14 |
GnuPG | gpg (GnuPG/MacGPG2) 2.2.10 (`gpg --version`)
Scala | 2.12.7 (`sbt ";reload plugins;show scalaVersion"`)
sbt | 1.2.1 (`grep "sbt.version" project/build.properties`)
sbt-gpg | 1.0.0 (`grep "sbt-gpg" project/plugins.sbt`)

**Steps To Reproduce**
Steps to reproduce the behaviour:
1. Use the following `build.sbt` file:
```sbt
gpgPassphrase := Some("password123")
gpgKeyFile := file("travis") / "key.asc"
gpgKeyFingerprint := "8BD27F291CB15ABD0DEFA583674FFAE89237F93F!"
```
2. Run `sbt gpgListKeys`

**Expected Behaviour**
A clear and concise description of what you expected to happen.

**Actual Behaviour**
A clear and concise description of what actually happened.

**Screenshots and/or Logs**
Add screenshots and/or logs to help explain your problem.

**Additional Context**
Add any other context about the problem here.
