# sample-graalvm

Experiments with GraalVM

## Build and Run:

    $ mvn clean verify    
    $ java -cp target/sample-graalvm.jar com.github.phoswald.sample.Application

    $ docker run -it --rm \
      -v $(pwd)/target:/target \
      -w /target \
      oracle/graalvm-ce:1.0.0-rc15 \
      native-image -cp sample-graalvm.jar com.github.phoswald.sample.Application sample-graalvm
    $ ./target/sample-graalvm

Feature | Size
------- | ------
Hello world | 2'496'552
ZonedDateTime | 4'107'928
Class.getName() | 4'116'120
Timezone, Charset, Environment, Properties | 8'486'912

## Issues

- Time zone is UTC, not time zone of host
- System properties user.country, user.language are missing
