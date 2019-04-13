# sample-graalvm

Build and run:

    $ mvn clean verify    
    $ java -cp target/sample-graalvm.jar com.github.phoswald.sample.Application

    $ ./native-image-docker.sh
    $ ./target/sample-graalvm

Feature | Sizes
------- | ------
Hello world | 2'496'552
ZonedDateTime | 4'107'928
Class.getName() | 4'116'120

Issues:
- Default time zone differs: correct for Java, UTC for default
