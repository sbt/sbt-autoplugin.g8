## Setup

Follow these instructions once to setup your project and then you can delete this file.

### Continuous Integration

Continuous integration builds are done with [Travis CI].

Head over to your [organization profile][Travis Profile] and enable the build on this project. You may need to sync the
account if the project does not appear in the list.

### Publishing

##### Create a GPG Key

Follow the instructions on [sbt-gpg - Travis CI] with the [BotTech/sbt-gpg] plugin.

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

Add the output to the `before_deploy` section of the `.travis.yml` file.
The paths should be relative to the `travis` directory. For example:
```yaml
before_deploy:
- openssl aes-256-cbc -K \$encrypted_12345abcdef -iv \$encrypted_12345abcdef -in travis/key.asc.enc -out travis/key.asc -d
```

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

Create an [OSS Bintray account][Bintray OSS Signup].

Add a new repository:
* Public
* Name: `sbt-plugins`
* Type: `Generic`

##### Encrypt Bintray Credentials

Go to your profile on Bintray and copy your API key and encrypt it.
```bash
travis encrypt
BINTRAY_PASS=YOUR_BINTRAY_API_KEY
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

#### Signing

Follow the instructions on [BotTech/sbt-gpg][BotTech/sbt-gpg Travis CI] to setup the GnuPG key and passphrase.

#### Promote Your Plugin

1. Include your plugin in the [community sbt repository][Community Repo].
1. Add your plugin to the [community plugins list][Community Plugins].
1. Add your plugin to the [Awesome Scala] list.
1. [Claim your project][Scaladex Claim Your Project] in the Scaladex.

[Awesome Scala]: https://github.com/lauris/awesome-scala
[Bintray OSS Signup]: https://bintray.com/signup/oss
[BotTech/sbt-gpg]: https://github.com/BotTech/sbt-gpg
[BotTech/sbt-gpg Travis CI]: https://github.com/BotTech/sbt-gpg#travis-ci
[Community Plugins]: https://github.com/sbt/website#attention-plugin-authors
[Community Repo]: https://www.scala-sbt.org/1.x/docs/Bintray-For-Plugins.html#Linking+your+package+to+the+sbt+organization
[Create GPG Key]: https://www.scala-sbt.org/sbt-pgp/usage.html
[sbt-gpg - Travis CI]: https://github.com/BotTech/sbt-gpg#travis-ci
[sbt-github-release]: https://github.com/ohnosequences/sbt-github-release
[Scaladex Claim You Project]: https://github.com/scalacenter/scaladex-contrib#claim-your-project
[Travis CI]: https://travis-ci.org
[Travis Encrypting Files]: https://docs.travis-ci.com/user/encrypting-files
[Travis Encryption Keys]: https://docs.travis-ci.com/user/encryption-keys
[Travis OAuth]: https://docs.travis-ci.com/user/deployment/releases/#authenticating-with-an-oauth-token
[Travis OSS]: https://docs.travis-ci.com/user/github-oauth-scopes/#travis-ci-for-open-source-projects
[Travis Profile]: https://travis-ci.org/profile/$organizationName$
