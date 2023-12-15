DESTINATION_JAVA = ../ktor-sample/proto/src/java
DESTINATION_KOTLIN = ../ktor-sample/proto/src/kotlin

.PHONY: gen
gen:clean add

.PHONY: clean
clean:
	rm -rf $(DESTINATION_JAVA)
	rm -rf $(DESTINATION_KOTLIN)

.PHONY: add
add:
	docker build -t example-protocol-buffers-proto-image .
	docker run --name example-protocol-buffers-proto example-protocol-buffers-proto-image
	docker cp example-protocol-buffers-proto:/root/proto/out/java $(DESTINATION_JAVA)
	docker cp example-protocol-buffers-proto:/root/proto/out/kotlin $(DESTINATION_KOTLIN)
	docker rm example-protocol-buffers-proto

.PHONY: proto
proto:
	mkdir -p ./out/java
	mkdir -p ./out/kotlin
	protoc --proto_path=./ -I=./ --java_out=./out/java --kotlin_out=./out/kotlin ./**/*.proto
