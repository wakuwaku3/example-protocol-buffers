.PHONY: gen
gen:clean add

.PHONY: clean
clean:
	rm -rf out

.PHONY: add
add:
	docker build -t example-protocol-buffers-proto-image .
	docker run --name example-protocol-buffers-proto example-protocol-buffers-proto-image
	docker cp example-protocol-buffers-proto:/root/proto/out ./
	docker rm example-protocol-buffers-proto

.PHONY: proto
proto:
	mkdir -p ./out/java
	mkdir -p ./out/kotlin
	protoc --proto_path=./ -I=./ --java_out=./out/java --kotlin_out=./out/kotlin ./**/*.proto
