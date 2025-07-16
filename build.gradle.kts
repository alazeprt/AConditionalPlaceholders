plugins {
    id("java")
    id("com.gradleup.shadow") version "8.3.6"
}

group = "top.alazeprt.acpapi"
version = "1.0"

repositories {
    maven("https://repo.extendedclip.com/releases/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    mavenCentral()
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.16.5-R0.1-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.11.6")
    implementation("org.springframework:spring-expression:5.3.39")
}