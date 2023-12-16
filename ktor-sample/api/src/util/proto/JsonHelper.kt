package com.example.api.util.proto

import com.google.protobuf.util.JsonFormat

object JsonHelper {
    val printer = JsonFormat.printer()!!
    val parser = JsonFormat.parser()!!
}
