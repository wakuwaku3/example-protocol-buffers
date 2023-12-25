FROM buildpack-deps:bookworm

LABEL Name="example-protocol-buffers-proto"
LABEL Version="1.0.0"

WORKDIR /root

RUN apt update && \
  apt -y install unzip
RUN curl -o protoc.zip -L https://github.com/protocolbuffers/protobuf/releases/download/v25.1/protoc-25.1-linux-x86_64.zip
RUN unzip protoc.zip -d protoc
RUN mv protoc/bin/* /usr/local/bin/
RUN mv protoc/include/* /usr/local/include/

COPY ./ /root/proto
WORKDIR /root/proto

# CMD tail -f /dev/null
CMD make proto-kotlin
