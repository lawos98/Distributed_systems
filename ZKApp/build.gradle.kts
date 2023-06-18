plugins {
    kotlin("jvm") version "1.8.21"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.graphstream:gs-core:2.0") // GraphStream Core library
    implementation("org.graphstream:gs-ui-swing:2.0") // GraphStream UI Swing library
    implementation("log4j:log4j:1.2.17")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("org.apache.zookeeper:zookeeper:3.8.0")
    implementation("org.apache.curator:curator-framework:5.2.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}