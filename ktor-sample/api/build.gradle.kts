import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// IntelliJのバグのせいでエラー発生するため仕方なくSuppressしている
// TODO: IntelliJのバグが直ったらSuppressを消す
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    java
    application
    kotlin("jvm")
    kotlin("plugin.serialization")
}

sourceSets {
    main {
        kotlin {
            srcDir("src")
        }
        resources {
            srcDir("resources")
        }
    }
    test {
        kotlin {
            srcDir("test")
        }
    }
}

group = "com.example"
version = "0.0.1"

dependencies {
    // coroutine
    implementation(libs.kotlinx.coroutines.core)
    // Ktor
    implementation(libs.bundles.ktor)
    // Jackson
    implementation(libs.bundles.jackson)
    // Inject
    implementation(libs.guice)
    // Log
    implementation(libs.bundles.logback)
    // Kotlinx Serialization Core
    implementation(libs.kotlinx.serialization.core)
    // protobuf
    implementation(libs.bundles.protobuf)

    implementation(project(":proto"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}
