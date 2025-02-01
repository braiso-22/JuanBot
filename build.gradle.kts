plugins {
    kotlin("jvm") version "1.9.23"
    application
}

group = "com.braiso_22"
version = ""

application{
    mainClass.set("Mainkt")
}

repositories {
    mavenCentral()
    maven("https://repo.kord.dev/snapshots")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("dev.kord:kord-core:0.15.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar{
    manifest.attributes["Main-Class"] = "com.braiso_22.MainKt"
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from({
        configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
    })
}

kotlin {
    jvmToolchain(17)
}
