pluginManagement {
  repositories {
      gradlePluginPortal()
      mavenCentral()
  }
}

dependencyResolutionManagement {
  repositories {
      mavenCentral()
      maven { setUrl("https://jitpack.io") }
  }

  versionCatalogs {
      create("libs") {
          // Kotlin
          version("kotlin", "1.7.21")
          library("kotlin-bom", "org.jetbrains.kotlin", "kotlin-bom").versionRef("kotlin")
          library("kotlin-reflect", "org.jetbrains.kotlin", "kotlin-reflect").withoutVersion()
          library("kotlin-test", "org.jetbrains.kotlin", "kotlin-test").withoutVersion()
          library(
              "kotlinx-serialization-core",
              "org.jetbrains.kotlinx",
              "kotlinx-serialization-core"
          ).version("1.4.1")
          library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").version("1.6.4")
          library("kotlinx-coroutines-test", "org.jetbrains.kotlinx", "kotlinx-coroutines-test").version("1.6.4")

          // Ktor
          version("ktor", "2.2.2")
          library("ktor-server-netty", "io.ktor", "ktor-server-netty").versionRef("ktor")
          library("ktor-server-auth", "io.ktor", "ktor-server-auth").versionRef("ktor")
          library("ktor-server-resources", "io.ktor", "ktor-server-resources").versionRef("ktor")
          library("ktor-server-content-negotiation", "io.ktor", "ktor-server-content-negotiation").versionRef("ktor")
          library("ktor-serialization-jackson", "io.ktor", "ktor-serialization-jackson").versionRef("ktor")
          library("ktor-server-data-conversion", "io.ktor", "ktor-server-data-conversion").versionRef("ktor")
          library("ktor-server-status-pages", "io.ktor", "ktor-server-status-pages").versionRef("ktor")
          library("ktor-server-double-receive", "io.ktor", "ktor-server-double-receive").versionRef("ktor")
          library("ktor-server-call-logging", "io.ktor", "ktor-server-call-logging").versionRef("ktor")
          library("ktor-server-freemarker", "io.ktor", "ktor-server-freemarker").versionRef("ktor")
          library("ktor-server-tests", "io.ktor", "ktor-server-tests").versionRef("ktor")
          library("ktor-server-test-host", "io.ktor", "ktor-server-test-host").versionRef("ktor")

          // JsonObject
          library("simplejson", "com.googlecode.json-simple", "json-simple").version("1.1.1")

          // Misc
          version("jackson", "2.14.1")
          library("jackson-kotlin", "com.fasterxml.jackson.module", "jackson-module-kotlin").versionRef("jackson")
          library("jackson-jsr310", "com.fasterxml.jackson.datatype", "jackson-datatype-jsr310").versionRef("jackson")

          version("fuel", "2.3.1")
          library("fuel", "com.github.kittinunf.fuel", "fuel").versionRef("fuel")
          library("fuel-jackson", "com.github.kittinunf.fuel", "fuel-jackson").versionRef("fuel")

          library("guice", "com.google.inject", "guice").version("5.1.0")
          library("apache-commons-csv", "org.apache.commons", "commons-csv").version("1.9.0")
          library("opencsv", "com.opencsv", "opencsv").version("5.7.1")
          library("apache-commons-lang", "org.apache.commons", "commons-lang3").version("3.12.0")
          library("logback-classic", "ch.qos.logback", "logback-classic").version("1.4.5")
          library("ipaddress", "com.github.seancfoley", "ipaddress").version("5.4.0")

          library("jnanoid", "com.aventrix.jnanoid", "jnanoid").version("2.0.0")

          version("logbackContrib", "0.1.5")
          library(
              "logback-json-classic",
              "ch.qos.logback.contrib",
              "logback-json-classic"
          ).versionRef("logbackContrib")
          library("logback-jackson", "ch.qos.logback.contrib", "logback-jackson").versionRef("logbackContrib")

          library("kotlin-logging", "io.github.microutils", "kotlin-logging").version("3.0.4")

          // QR
          version("zxing", "3.5.1")
          library("zxing-core", "com.google.zxing", "core").versionRef("zxing")
          library("zxing-javase", "com.google.zxing", "javase").versionRef("zxing")
          library("boofcv", "org.boofcv", "boofcv-core").version("0.41")

          library("qrgen-javase", "com.github.kenglxn.QRGen", "javase").version("3.0.1")
          library("imageio-tiff", "com.twelvemonkeys.imageio", "imageio-tiff").version("3.9.4")
          library("icu4j", "com.ibm.icu", "icu4j").version("72.1")
          library("clikt", "com.github.ajalt.clikt", "clikt").version("3.5.2")

          // Test
          library("assertj-core", "org.assertj", "assertj-core").version("3.23.1")
          library("mockk", "io.mockk", "mockk").version("1.13.3")

          version("junit", "5.9.1")
          library("junit-bom", "org.junit", "junit-bom").versionRef("junit")
          library("junit-jupiter", "org.junit.jupiter", "junit-jupiter").versionRef("junit")

          library("system-stubs-jupiter", "uk.org.webcompere", "system-stubs-jupiter").version("2.0.2")

          library("json-fuzzy-match", "io.github.orangain", "json-fuzzy-match").version("0.5.0")
          library("wiremock", "com.github.tomakehurst", "wiremock-jre8").version("2.35.0")
          library("kotlin-test-junit", "org.jetbrains.kotlin", "kotlin-test-junit").version("1.7.22")

          bundle("kotlin", listOf("kotlin-reflect"))
          bundle("kotlin-test", listOf("kotlin-test"))
          bundle(
              "ktor",
              listOf(
                  "ktor-server-netty",
                  "ktor-server-auth",
                  "ktor-server-resources",
                  "ktor-server-content-negotiation",
                  "ktor-serialization-jackson",
                  "ktor-server-data-conversion",
                  "ktor-server-status-pages",
                  "ktor-server-double-receive",
                  "ktor-server-call-logging"
              )
          )
          bundle("jackson", listOf("jackson-kotlin", "jackson-jsr310"))
          bundle("fuel", listOf("fuel", "fuel-jackson"))
          bundle("logback", listOf("logback-classic", "logback-json-classic", "logback-jackson"))
          bundle("test-ktor", listOf("ktor-server-tests", "ktor-server-test-host"))
          bundle("test-unit", listOf("assertj-core", "junit-jupiter"))
          bundle("test-api", listOf("assertj-core", "junit-jupiter", "mockk"))

          plugin("kotlin-jvm", "org.jetbrains.kotlin.jvm").versionRef("kotlin")
          plugin("kotlinx-serialization", "org.jetbrains.kotlin.plugin.serialization").versionRef("kotlin")
          plugin("shadow", "com.github.johnrengelman.shadow").version("7.1.2")
          plugin("download", "de.undercouch.download").version("5.3.0")
          plugin(
              "javaagent",
              "com.ryandens.javaagent-application"
          ).version("0.5.0") // / https://github.com/ryandens/javaagent-gradle-plugin
          plugin("spotless", "com.diffplug.spotless").version("6.18.0")
          plugin("testRetry", "org.gradle.test-retry").version("1.5.3")
      }
  }
}

rootProject.name = "ktor-sample"
include("proto")
include("api")
