plugins {
    kotlin("jvm") version "2.0.0"
}

group = "com.github.speisz"

repositories {
    mavenCentral()
}

val junitVersion = "5.10.3"

dependencies {
    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    testImplementation("org.assertj:assertj-core:3.26.0")

    testImplementation("org.mockito.kotlin:mockito-kotlin:5.3.1")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}
