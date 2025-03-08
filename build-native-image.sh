#!/bin/bash
export MUSL_HOME="${HOME}/bin/musl"
export PATH="${MUSL_HOME}/bin/:${PATH}"
native-image \
  --no-fallback --static --libc=musl \
  -cp target/sample-graalvm-*.jar \
  com.github.phoswald.sample.Application \
  target/sample-graalvm
