plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("com.github.jmongard.git-semver-plugin") version "0.14.0"
    kotlin("jvm") version "2.1.10"
}

semver {
    releaseTagNameFormat = "v%s"
}

group = "com.github.sigureruri"
version = semver.version

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://oss.sonatype.org/content/groups/public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.18.2-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.1.10")
}

tasks.getByName<ProcessResources>("processResources") {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    filesMatching("plugin.yml") {
        expand("version" to project.version)
    }
}

tasks.getByName<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar") {
    archiveBaseName.set(rootProject.name)
    archiveClassifier.set("")
}

kotlin {
    jvmToolchain(17)
}
