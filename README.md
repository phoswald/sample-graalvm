# sample-graalvm

Experiments with GraalVM

## Build and Run:

    $ mvn clean verify    
    $ java -cp target/sample-graalvm.jar com.github.phoswald.sample.Application

    $ native-image -cp target/sample-graalvm.jar --no-fallback com.github.phoswald.sample.Application target/sample-graalvm
    $ ./target/sample-graalvm
    $ ldd target/sample-graalvm

Feature | Size (in 1.0.0-rc15)
------- | ------
Hello world | 2'496'552
ZonedDateTime | 4'107'928
Class.getName() | 4'116'120
Timezone, Charset, Environment, Properties | 8'486'912

## Issues (in 1.0.0-rc15)

- Time zone is UTC, not time zone of host
- System properties user.country, user.language are missing
