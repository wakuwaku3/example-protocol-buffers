// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: schema/cat.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package com.example.cat;

@kotlin.jvm.JvmName("-initializecatServiceGetResponseChild")
public inline fun catServiceGetResponseChild(block: com.example.cat.CatServiceGetResponseChildKt.Dsl.() -> kotlin.Unit): com.example.cat.CatServiceGetResponseChild =
  com.example.cat.CatServiceGetResponseChildKt.Dsl._create(com.example.cat.CatServiceGetResponseChild.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `CatServiceGetResponseChild`
 */
public object CatServiceGetResponseChildKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.example.cat.CatServiceGetResponseChild.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.example.cat.CatServiceGetResponseChild.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.example.cat.CatServiceGetResponseChild = _builder.build()

    /**
     * `string id = 1;`
     */
    public var id: kotlin.String
      @JvmName("getId")
      get() = _builder.getId()
      @JvmName("setId")
      set(value) {
        _builder.setId(value)
      }
    /**
     * `string id = 1;`
     */
    public fun clearId() {
      _builder.clearId()
    }

    /**
     * `string name = 2;`
     */
    public var name: kotlin.String
      @JvmName("getName")
      get() = _builder.getName()
      @JvmName("setName")
      set(value) {
        _builder.setName(value)
      }
    /**
     * `string name = 2;`
     */
    public fun clearName() {
      _builder.clearName()
    }

    /**
     * `string kind = 3;`
     */
    public var kind: kotlin.String
      @JvmName("getKind")
      get() = _builder.getKind()
      @JvmName("setKind")
      set(value) {
        _builder.setKind(value)
      }
    /**
     * `string kind = 3;`
     */
    public fun clearKind() {
      _builder.clearKind()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun com.example.cat.CatServiceGetResponseChild.copy(block: `com.example.cat`.CatServiceGetResponseChildKt.Dsl.() -> kotlin.Unit): com.example.cat.CatServiceGetResponseChild =
  `com.example.cat`.CatServiceGetResponseChildKt.Dsl._create(this.toBuilder()).apply { block() }._build()

