#!/bin/bash
docker run -it --rm \
  -e PATH=/usr/local/musl/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin \
  -v $(pwd)/target:/target \
  -w / \
  native-image-community-musl:22.0.1 \
  "$@" \
  -cp target/sample-graalvm-*.jar com.github.phoswald.sample.Application \
  target/sample-graalvm
