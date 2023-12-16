FROM buildpack-deps:bookworm

LABEL Name="example-protocol-buffers-proto"
LABEL Version="1.0.0"

ADD ./ /root/proto

WORKDIR /root/proto
RUN apt update && \
  apt -y install unzip
RUN curl -o protoc.zip -L https://github.com/protocolbuffers/protobuf/releases/download/v25.1/protoc-25.1-linux-x86_64.zip
RUN unzip protoc.zip -d protoc
RUN mv protoc/bin/* /usr/local/bin/
RUN mv protoc/include/* /usr/local/include/


CMD make proto
