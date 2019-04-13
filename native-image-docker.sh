#!/bin/bash
docker run -it --rm \
  -v $(pwd)/target:/target \
  -w /target \
  oracle/graalvm-ce:1.0.0-rc15 \
  native-image -cp sample-graalvm.jar com.github.phoswald.sample.Application sample-graalvm
