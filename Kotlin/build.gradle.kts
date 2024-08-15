plugins {
    kotlin("jvm") version "1.8.10"
    id("io.ktor.plugin") version "2.2.2"
}

group = "com.example"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("com.example.ServerKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:2.2.2")
    implementation("io.ktor:ktor-server-netty:2.2.2")
    implementation("io.ktor:ktor-server-html-builder:2.2.2")
    implementation("io.ktor:ktor-server-sessions:2.2.2")
    implementation("io.ktor:ktor-server-auth:2.2.2")
    implementation("ch.qos.logback:logback-classic:1.2.11")
}
