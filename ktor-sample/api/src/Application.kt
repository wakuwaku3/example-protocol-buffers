package com.example.api

import com.example.api.util.ktor.ApplicationCallExtensions.receiveMessage
import com.example.api.util.ktor.ApplicationCallExtensions.responseMessage
import com.example.cat.CatServiceGetResponse
import com.example.cat.catServiceGetResponse
import com.example.cat.catServiceGetResponseChild
import com.google.protobuf.timestamp
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import java.time.Instant

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@JvmOverloads
fun Application.module(testing: Boolean = false) {

    routing {
        get("/") {
            // curl -X GET http://localhost:8080
            val res = catServiceGetResponse {
                id = "1"
                name = "tama"
                kind = "mike"
                birthedAt = timestamp {
                    Instant.now().let {
                        seconds = it.epochSecond
                        nanos = it.nano
                    }
                }
                children.addAll(
                    listOf(
                        catServiceGetResponseChild {
                            id = "2"
                            name = "mike"
                            kind = "tama"
                        },
                        catServiceGetResponseChild {
                            id = "3"
                            name = "mike"
                            kind = "tama"
                        },
                    ),
                )
            }
            call.responseMessage(res)
        }
        post("/") {
            // curl -X POST -H "Content-Type: application/json" -d '{"id":"1","name":"tama","kind":"mike","birthedAt":"2023-12-16T07:11:48.012244270Z","children":[{"id":"2","name":"mike","kind":"tama"},{"id":"3","name":"mike","kind":"tama"}]}' http://localhost:8080
            val res = call.receiveMessage(CatServiceGetResponse.getDefaultInstance())
            println(res)
            call.responseMessage(res)
        }
    }
}
