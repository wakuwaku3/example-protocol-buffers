package com.example.api.util.ktor

import com.example.api.util.proto.JsonHelper
import com.google.protobuf.MessageOrBuilder
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receiveText
import io.ktor.server.response.respondText

object ApplicationCallExtensions {
    suspend fun ApplicationCall.responseMessage(
        message: MessageOrBuilder,
        httpStatusCode: HttpStatusCode = HttpStatusCode.OK,
    ) {
        respondText(JsonHelper.printer.print(message), ContentType.Application.Json, httpStatusCode)
    }

    @Suppress("UNCHECKED_CAST")
    suspend fun <TMessage> ApplicationCall.receiveMessage(m: TMessage): TMessage where TMessage : MessageOrBuilder {
        val builder = m.defaultInstanceForType.toBuilder()
        JsonHelper.parser.merge(receiveText(), builder)

        return builder.build() as TMessage
    }
}
