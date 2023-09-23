#!/bin/bash
docker run -it --rm \
  -v $(pwd)/target:/target \
  -w / \
  ghcr.io/graalvm/native-image-community:21 \
  "$@" \
  -cp target/sample-graalvm-*.jar com.github.phoswald.sample.Application \
  target/sample-graalvm
