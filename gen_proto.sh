#!/usr/bin/bash

mkdir -p ./generated
printf "import sys\nfrom pathlib import Path\nsys.path.append(str(Path(__file__).parent))" > ./generated/__init__.py
python -m grpc_tools.protoc \
          -I=. \
          --python_out=. \
          --pyi_out=. \
          --grpc_python_out=. \
          orders.proto