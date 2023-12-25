DESTINATION = ../ktor-sample/proto/src/main
DESTINATION_JAVA = $(DESTINATION)/java
DESTINATION_KOTLIN = $(DESTINATION)/kotlin

.PHONY: gen
gen:gen-kotlin

.PHONY: gen-kotlin
gen-kotlin:clean-kotlin add-kotlin

.PHONY: clean-kotlin
clean-kotlin:
	rm -rf $(DESTINATION_JAVA)
	rm -rf $(DESTINATION_KOTLIN)

.PHONY: add-kotlin
add-kotlin:
	mkdir -p $(DESTINATION)
	docker ps -q -a -f name=example-protocol-buffers-proto | xargs -r docker stop | xargs -r docker rm
	docker build -t example-protocol-buffers-proto-image -f containers/kotlin/Dockerfile .
	docker run --name example-protocol-buffers-proto example-protocol-buffers-proto-image
	docker cp example-protocol-buffers-proto:/root/proto/out/java $(DESTINATION_JAVA)
	docker cp example-protocol-buffers-proto:/root/proto/out/kotlin $(DESTINATION_KOTLIN)
	docker rm example-protocol-buffers-proto

.PHONY: proto-kotlin
proto-kotlin:
	mkdir -p ./out/java
	mkdir -p ./out/kotlin
	protoc --proto_path=. --java_out=./out/java --kotlin_out=./out/kotlin ./schema/*.proto

.PHONY: install
install:
	go install github.com/yoheimuta/protolint/cmd/protolint@latest

.PHONY: lint
lint:
	protolint lint .
