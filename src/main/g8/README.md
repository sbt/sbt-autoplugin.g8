# $name$

[![Build Status](https://travis-ci.org/$organizationName;format="word"$/$name$.svg?branch=master)](https://travis-ci.org/$organizationName;format="word"$/$name$)
[![Download](https://api.bintray.com/packages/$organizationName;format="word,lower"$/sbt-plugins/$name$/images/download.svg) ](https://bintray.com/$organizationName;format="word,lower"$/sbt-plugins/$name$/_latestVersion)

$purpose$

## Usage

This plugin requires sbt 1.0.0+

### Testing

Run `test` for regular unit tests.

Run `scripted` for [sbt script tests](http://www.scala-sbt.org/1.x/docs/Testing-sbt-plugins.html).

### PGP Keys

1. Follow the instructions on [Creating a Key Pair](https://www.scala-sbt.org/sbt-pgp/usage.html) with the sbt-pgp plugin.
1. Go to Github and create a Personal access token with the scopes listed on
[Travis CI for Open Source Projects](https://docs.travis-ci.com/user/github-oauth-scopes/#travis-ci-for-open-source-projects).
   * Don't forget to copy it!
1. Next encrypt the PGP private key using the instructions on [Encrypting Files](https://docs.travis-ci.com/user/encrypting-files/).
   1. `gem install travis`
   1. `travis login -g YOUR_GITHUB_TOKEN`
   1. `travis encrypt-file ~/.sbt/gpg/secring.asc --decrypt-to travis/secring.asc`
   1. Add it to `.travis.yml`
1. Move the files:
   1. `mkdir travis`
   1. `cp ~/.sbt/gpg/pubring.asc travis/`
   1. `mv secring.asc.enc travis/`
1. Now encrypt the PGP passphrase using the instructions on [Encryption Keys](https://docs.travis-ci.com/user/encryption-keys/).
   1. `travis encrypt`
   1. At the prompt: `PGP_PASS=YOUR_PGP_PASSPHRASE`
   1. Add it to `.travis.yml`
1. Tidy up the `.travis.yml` file. Also fix the `secring.asc.enc`.

### Github OAuth Token

We generated a Github Token for the Travis CLI but now we need one that can be encrypted and included in the build.
1. Go to Github and create a Personal access token with the scopes listed on
[Authenticating with an OAuth token](https://docs.travis-ci.com/user/deployment/releases/#authenticating-with-an-oauth-token).
   * Don't forget to copy it!
1. Now encrypt the token using the instructions on [Encryption Keys](https://docs.travis-ci.com/user/encryption-keys/).
   1. `travis encrypt`
   1. At the prompt: `GITHUB_TOKEN=YOUR_GITHUB_TOKEN`
   1. Add it to `.travis.yml`

### Publishing

1. publish your source to GitHub
2. [create a bintray account](https://bintray.com/signup/index) and [set up bintray credentials](https://github.com/sbt/sbt-bintray#publishing)
3. create a bintray repository `sbt-plugins` 
4. update your bintray publishing settings in `build.sbt`
5. `sbt publish`
6. [request inclusion in sbt-plugin-releases](https://bintray.com/sbt/sbt-plugin-releases)
7. [Add your plugin to the community plugins list](https://github.com/sbt/website#attention-plugin-authors)
8. [Claim your project an Scaladex](https://github.com/scalacenter/scaladex-contrib#claim-your-project)
