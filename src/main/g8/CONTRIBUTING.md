## Contributing

TODO.

### Testing

Run `test` for regular unit tests.

Run `scripted` for [sbt script tests][Testing sbt Plugins].

### Versioning

Version numbers are determined automatically using [sbt-dynver].

To create a new version add a new git annotated tag:
```bash
git tag -a v1.1.0
```

### Continuous Integration

Continuous integration builds are done with [Travis CI].

### Publishing

The Travis CI build will automatically publish to [Bintray] and [GitHub] for all tagged commits on master.

#### Signed Artifacts

TODO.

#### Bintray

This uses [sbt-bintray] to publish artifacts to Bintray.

[Bintray]: https://bintray.com
[Github]: https://github.com
[sbt-bintray]: https://github.com/sbt/sbt-bintray
[sbt-dynver]: https://github.com/dwijnand/sbt-dynver
[Testing sbt Plugins]: http://www.scala-sbt.org/1.x/docs/Testing-sbt-plugins.html
[Travis CI]: https://travis-ci.org
