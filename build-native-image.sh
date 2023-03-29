#!/bin/bash
# --no-fallback: build a standalone native executable or report a failure
# --static:      can be specified to build static image (can use 'FROM scratch' in Docker)
# no effect: -e LANGUAGE=en_GB
# no effect: -e LANG=en_GB.UTF-8
# no effect: -e LC_ALL=de_CH.UTF-8
docker run -it --rm \
  -v $(pwd)/target:/target \
  -w / \
  ghcr.io/graalvm/native-image:22.3.1 \
  --no-fallback "$@" \
  -cp target/sample-graalvm-*.jar com.github.phoswald.sample.Application \
  -Dfile.encoding=UTF-8 \
  target/sample-graalvm
