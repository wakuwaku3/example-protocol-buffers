plugins {
    // IntelliJのバグのせいでエラー発生するため仕方なくSuppressしている
    // TODO: IntelliJのバグが直ったらSuppressを消す
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.kotlin.jvm) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.kotlinx.serialization) apply false
}
