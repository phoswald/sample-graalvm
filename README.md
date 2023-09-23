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
$ ./native-image.sh --no-fallback
$ ./native-image.sh --no-fallback --static

$ ./native-image-docker.sh --no-fallback
$ ./native-image-docker.sh --no-fallback --static

$ file target/sample-graalvm
$ ldd  target/sample-graalvm

$ ./target/sample-graalvm
$ ./target/sample-graalvm charset
$ ./target/sample-graalvm locale
$ ./target/sample-graalvm prop
$ ./target/sample-graalvm -Dapp.sample=hello prop
~~~

Output:

- default: dynamically linked ELF, size 13'901'760, depending on `libz.so.1`, `libc.so.6`, `linux-vdso.so.1`, `ld-linux-x86-64.so.2`
- with `--static`: statically linked ELF, size 15'513'328

## Differences between java and native-image

- `Locale.getDefault()` returns `en_US` instead of `en_GB` if built in Docker.
- System properties `native.encoding`, `stderr.encoding` and `stdout.encoding` are `ANSI_X3.4-1968` instead of `UTF-8` if built in Docker
- System property `java.class.path` is empty
- System property `java.home` is not set (but `java.endorsed.dirs` and `java.ext.dirs` are set and empty)
- System property `java.library.path` differs
- System properties `java.runtime.name` and `java.runtime.version` are not set
- System properties `java.vendor*` and `java.vm*` and `sun.*` differ
- System properties `user.country` and `user.language` are not set
