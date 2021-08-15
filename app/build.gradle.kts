/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.0/userguide/building_java_projects.html
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")

    // Hamcrest library for assertions.
    testImplementation("org.hamcrest:hamcrest:2.2")

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:30.0-jre")

    // openjdk java object layout library
    implementation("org.openjdk.jol:jol-core:0.10")
}

application {
    // Define the main class for the application.
    mainClass.set("scratchpad.App")
}

tasks.test {
    // Use junit platform for unit tests.
    useJUnitPlatform()
}
