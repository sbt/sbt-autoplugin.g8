# $name$

[![Build Status][Build Status]](https://travis-ci.org/$organizationName;format="word"$/$name$)
[![Download][Download]](https://bintray.com/$organizationName;format="word,lower"$/sbt-plugins/$name$/_latestVersion)

$purpose$

## Usage

This plugin requires sbt 1.0.0+.

### Testing

Run `test` for regular unit tests.

Run `scripted` for [sbt script tests][Testing Plugins].

### Versioning

Version numbers are determined automatically using [sbt-dynver][sbt-dynver].

To create a new version add a new git annotated tag:
```bash
git tag -a v1.1.0
```

### Publishing

The Travis CI build will automatically publish to Bintray and GitHub for all tagged commits on master.

#### Signed Artifacts

This uses [sbt-pgp][sbt-pgp] to sign the packaged artifacts.

##### Create the GPG Key

Follow the instructions on [creating a key pair][Create GPG Key] with the sbt-pgp plugin.

```sbtshell
set pgpReadOnly := false
pgp-cmd gen-key
```

##### Travis GitHub Token

We will use the Travis CLI to encrypt all the secrets to be used in the build.

Go to GitHub and create a Personal access token with the following scopes:
* `user:email`
* `read:org`
* `repo_deployment`
* `repo:status`
* `write:repo_hook`

See [Travis CI for open source projects][Travis OSS] on what these scopes are used for.

Save the token somewhere safe as you will need it to login to the Travis CLI and if you forget it you will need to
generate a new one.

##### Encrypt the GPG Secret Key

Next encrypt the GPG secret key using the instructions on [encrypting files][Travis Encrypting Files].

Install the Travis CLI:
```bash
gem install travis
```

Login using the GitHub Token:
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

Now encrypt the GPG passphrase using the instructions on [encryption keys][Travis Encryption Keys].
```bash
travis encrypt
PGP_PASS=YOUR_PGP_PASSPHRASE
```

Add the output to the `env.global` section of the `.travis.yml` file.

#### Bintray

This uses [sbt-bintray][sbt-bintray] to publish artifacts to Bintray.

Create an [OSS Bintray account][Bintray OSS Signup].

Add a new repository:
* Public
* Name: `sbt-plugins`
* Type: `Generic`

##### Encrypt Bintray Credentials

Go to your profile on [Bintray][Bintray] and copy your API key and encrypt it.
```bash
travis encrypt
BINTRAY_PASS=YOUR_PGP_PASSPHRASE
```

Add the output to the `env.global` section of the `.travis.yml` file.
Also add your Bintray user name to the `BINTRAY_USER` environment variable.

#### GitHub OAuth Token

[ohnosequences/sbt-github-release][sbt-github-release] is used to publish the artifacts to GitHub.

Generate a separate GitHub token for use in the build which has the following scopes:
* `public_repo`

See [Authenticating with an OAuth token][Travis OAuth] for the details.

Now encrypt the token:
```bash
travis encrypt
GITHUB_TOKEN=YOUR_GITHUB_TOKEN
```

Add the output to the `env.global` section of the `.travis.yml` file.

#### Promote Your Plugin

1. Include your plugin in the [community sbt repository][Community Repo].
1. Add your plugin to the [community plugins list][Community Plugins].
1. Add your plugin to the [Awesome Scala][Awesome Scala] list.
1. [Claim your project][Scaladex] in the Scaladex.

## Credits

This plugin was generated from the [BotTech/sbt-autoplugin.g8][sbt-autoplugin] Giter8 template.

Special thanks to:
* [GitHub][Github] for hosting the git repository.
* [Travis CI][Travis CI] for running the build.
* [JFrog][JFrog] for distributing the releases on Bintray.
* [Lightbend][Lightbend] for distributing the plugin in the community sbt repository.
* All the other OSS contributors who made this project possible.

[Awesome Scala]: https://github.com/lauris/awesome-scala
[Bintray]: https://bintray.com
[Bintray OSS Signup]: https://bintray.com/signup/oss
[Build Status]: https://travis-ci.org/$organizationName;format="word"$/$name$.svg?branch=master
[Community Plugins]: https://github.com/sbt/website#attention-plugin-authors
[Community Repo]: https://www.scala-sbt.org/1.x/docs/Bintray-For-Plugins.html#Linking+your+package+to+the+sbt+organization
[Create GPG Key]: https://www.scala-sbt.org/sbt-pgp/usage.html
[Download]: https://api.bintray.com/packages/$organizationName;format="word,lower"$/sbt-plugins/$name$/images/download.svg
[Github]: https://github.com
[JFrog]: https://jfrog.com
[Lightbend]: https://www.lightbend.com
[sbt-autoplugin]: https://github.com/BotTech/sbt-autoplugin.g8
[sbt-bintray]: https://github.com/sbt/sbt-bintray
[sbt-dynver]: https://github.com/dwijnand/sbt-dynver
[sbt-github-release]: https://github.com/ohnosequences/sbt-github-release
[sbt-pgp]: https://github.com/sbt/sbt-pgp
[Scaladex]: https://github.com/scalacenter/scaladex-contrib#claim-your-project
[Testing Plugins]: http://www.scala-sbt.org/1.x/docs/Testing-sbt-plugins.html
[Travis CI]: https://travis-ci.org
[Travis Encrypting Files]: https://docs.travis-ci.com/user/encrypting-files
[Travis Encryption Keys]: https://docs.travis-ci.com/user/encryption-keys
[Travis OAuth]: https://docs.travis-ci.com/user/deployment/releases/#authenticating-with-an-oauth-token
[Travis OSS]: https://docs.travis-ci.com/user/github-oauth-scopes/#travis-ci-for-open-source-projects
