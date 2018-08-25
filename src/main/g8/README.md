# $name$

[![Build Status](https://travis-ci.org/$organizationName;format="word"$/$name$.svg?branch=master)](https://travis-ci.org/$organizationName;format="word"$/$name$)
[![Download](https://api.bintray.com/packages/$organizationName;format="word,lower"$/sbt-plugins/$name$/images/download.svg) ](https://bintray.com/$organizationName;format="word,lower"$/sbt-plugins/$name$/_latestVersion)

$purpose$

## Usage

This plugin requires sbt 1.0.0+.

### Testing

Run `test` for regular unit tests.

Run `scripted` for [sbt script tests](http://www.scala-sbt.org/1.x/docs/Testing-sbt-plugins.html).

### Publishing

#### Signed Artifacts

This uses [sbt-pgp](https://github.com/sbt/sbt-pgp) to sign the packaged artifacts.

##### Create the GPG Key

Follow the instructions on [Creating a Key Pair](https://www.scala-sbt.org/sbt-pgp/usage.html) with the sbt-pgp plugin.

```sbtshell
set pgpReadOnly := false
pgp-cmd gen-key
```

##### Travis Github Token

We will use the Travis CLI to encrypt all the secrets to be used in the build.

Go to Github and create a Personal access token with the following scopes:
* `user:email`
* `read:org`
* `repo_deployment`
* `repo:status`
* `write:repo_hook`

See [Travis CI for Open Source Projects](https://docs.travis-ci.com/user/github-oauth-scopes/#travis-ci-for-open-source-projects)
on what these scopes are used for.

Save the token somewhere safe as you will need it to login to the Travis CLI and if you forget it you will need to
generate a new one.

##### Encrypt the GPG Secret Key

Next encrypt the GPG secret key using the instructions on [Encrypting Files](https://docs.travis-ci.com/user/encrypting-files/).

Install the Travis CLI:
```bash
gem install travis
```

Login using the Github Token:
```bash
travis login -g YOUR_GITHUB_TOKEN
```

Encrypt the secret key:
```bash
travis encrypt-file travis/secring.asc
```

Add the output to the `env.global` section of the `.travis.yml` file.

Move the encrypted secret key:
```bash
mv secring.asc.enc travis/
```

Delete the unencrypted secret key:
```bash
rm travis/secring.asc
```

Now encrypt the GPG passphrase using the instructions on [Encryption Keys](https://docs.travis-ci.com/user/encryption-keys/).
```bash
travis encrypt
PGP_PASS=YOUR_PGP_PASSPHRASE
```

Add the output to the `env.global` section of the `.travis.yml` file.

#### Bintray

This uses [sbt-bintray](https://github.com/sbt/sbt-bintray) to publish the artifacts to Bintray.

##### Encrypt Bintray Credentials

Go to your profile on [Bintray](https://bintray.com) and copy your API key and encrypt it.
```bash
travis encrypt
BINTRAY_PASS=YOUR_PGP_PASSPHRASE
```

Add the output to the `env.global` section of the `.travis.yml` file.
Also add your Bintray user name to the `BINTRAY_USER` environment variable.

#### Github OAuth Token

[ohnosequences/sbt-github-release](https://github.com/ohnosequences/sbt-github-release) is used to publish the artifacts to Github.

Generate a separate Github token for use in the build which has the following scopes:
* `public_repo`

See [Authenticating with an OAuth token](https://docs.travis-ci.com/user/deployment/releases/#authenticating-with-an-oauth-token)
for the details.

Now encrypt the token:
```bash
travis encrypt
GITHUB_TOKEN=YOUR_GITHUB_TOKEN
```

Add the output to the `env.global` section of the `.travis.yml` file.

### Publishing

1. publish your source to GitHub
2. [create a bintray account](https://bintray.com/signup/index) and [set up bintray credentials](https://github.com/sbt/sbt-bintray#publishing)
3. create a bintray repository `sbt-plugins` 
4. update your bintray publishing settings in `build.sbt`
5. `sbt publish`
6. [request inclusion in sbt-plugin-releases](https://bintray.com/sbt/sbt-plugin-releases)
7. [Add your plugin to the community plugins list](https://github.com/sbt/website#attention-plugin-authors)
8. [Claim your project an Scaladex](https://github.com/scalacenter/scaladex-contrib#claim-your-project)
