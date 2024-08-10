plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("com.github.jmongard.git-semver-plugin") version "0.12.10"
    kotlin("jvm") version "1.9.25"
}

semver {
    releaseTagNameFormat = "v%s"
}

group = "com.github.sigureruri"
version = semver.version

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.16.5-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.10")
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