# sample-graalvm

Experiments with GraalVM

Links:

- https://www.graalvm.org/latest/reference-manual/native-image/overview/BuildOptions/
- https://github.com/graalvm/container/pkgs/container/native-image

## Build and Run

~~~
$ mvn clean verify
$ java -cp target/sample-graalvm-*.jar com.github.phoswald.sample.Application
$ java -cp target/sample-graalvm-*.jar com.github.phoswald.sample.Application prop
~~~

~~~
$ mvn clean verify && ./build-native-image.sh
$ mvn clean verify && ./build-native-image.sh --static

$ file target/sample-graalvm
$ ldd  target/sample-graalvm

$ ./target/sample-graalvm
$ ./target/sample-graalvm charset
$ ./target/sample-graalvm locale
$ ./target/sample-graalvm prop
$ ./target/sample-graalvm -Dapp.sample=hello prop
~~~

## Differences between native-image and java:

- `Charset.defaultCharset()` returns `US-ASCII` instead of `UTF-8`
  unless `-Dfile.encoding=UTF-8` is passed to `native-image`.
  
- `Locale.getDefault()` returns `en_US` instead of `en_GB`.

- System property `file.encoding` and `native.encoding` is `ANSI_X3.4-1968` instead of `UTF-8`
- System property `java.class.path` is empty
- System property `java.home` is not set (but `java.endorsed.dirs` and `java.ext.dirs` are set and empty)
- System property `java.library.path` differs
- System properties `java.runtime.name` and `java.runtime.version` are not set
- System properties `java.vendor*` and `java.vm*` and `sun.*` differ
- System properties `user.country` and `user.language` are not set
