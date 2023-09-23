#!/bin/bash
native-image \
  "$@" \
  -cp target/sample-graalvm-*.jar com.github.phoswald.sample.Application \
  target/sample-graalvm
