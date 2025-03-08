# sample-graalvm

Experiments with GraalVM's native-image

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
$ file target/sample-graalvm
$ ldd  target/sample-graalvm

$ ./target/sample-graalvm
$ ./target/sample-graalvm charset
$ ./target/sample-graalvm locale
$ ./target/sample-graalvm prop
$ ./target/sample-graalvm -Dapp.sample=hello prop
~~~

Output:

- default: dynamically linked ELF, size 14'092'472, depending on `libz.so.1`, `libc.so.6`, `linux-vdso.so.1`, `ld-linux-x86-64.so.2`
- with `--static-nolibc`: dynamically linked ELF, size 14'092'552, depending on `libc.so.6`, `linux-vdso.so.1`, `ld-linux-x86-64.so.2`
- with `--static --libc=musl`: statically linked ELF, size 13'698'264

## Differences between java and native-image

- `Locale.getDefault()` returns `en_US` instead of `en_GB` if built in Docker.
- System properties `native.encoding`, `stderr.encoding` and `stdout.encoding` 
  are `ANSI_X3.4-1968` (which is equivalent to `US-ASCII`) instead of `UTF-8` if built in Docker
- System property `java.class.path` is empty
- System property `java.home` is not set (but `java.endorsed.dirs` and `java.ext.dirs` are set and empty)
- System property `java.library.path` differs
- System properties `java.runtime.name` and `java.runtime.version` differ
- System properties `java.vendor*` and `java.vm*` and `sun.*` differ
- System properties `user.country` and `user.language` are not set

## Installation

Install native-image from https://github.com/graalvm/graalvm-ce-builds/releases

Install musl as described in https://www.graalvm.org/latest/reference-manual/native-image/guides/build-static-executables/ (only required for `native-image --static --libc=musl`)
