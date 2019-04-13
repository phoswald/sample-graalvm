# sample-graalvm

Experiments with GraalVM

## Build and run:

    $ mvn clean verify    
    $ java -cp target/sample-graalvm.jar com.github.phoswald.sample.Application

    $ ./native-image-docker.sh
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
