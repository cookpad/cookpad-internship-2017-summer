#! /bin/bash
#USAGE: bash run.sh

set -e

docker build -t cookpad-intern-ml -f docker/Dockerfile .

docker run -p 8888:8888 \
  --name cookpad-intern-ml \
  -v `pwd`/data:/work/data \
  -v `pwd`/notebooks:/work/notebooks \
  cookpad-intern-ml
