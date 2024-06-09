#!/bin/bash
docker run -it --rm \
  -v $(pwd)/target:/target \
  -w / \
  native-image-community-musl:22.0.1 \
  "$@" \
  -cp target/sample-graalvm-*.jar com.github.phoswald.sample.Application \
  target/sample-graalvm
