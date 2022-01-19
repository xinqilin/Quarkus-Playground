import java.util.regex.Pattern.compile

plugins {
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.allopen") version "1.6.10"
    id("io.quarkus")
    id("org.jetbrains.kotlin.plugin.jpa") version "1.3.61"
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-smallrye-reactive-messaging-kafka")
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-hibernate-orm-panache")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.quarkus:quarkus-arc")
    implementation ("io.quarkus:quarkus-resteasy")
    implementation ("io.quarkus:quarkus-flyway")
    implementation ("io.quarkus:quarkus-jdbc-postgresql")
    implementation ("io.quarkus:quarkus-resteasy-jsonb")
    implementation ("io.quarkus:quarkus-jsonb")
    implementation ("io.quarkus:quarkus-reactive-pg-client")
    implementation ("io.quarkus:quarkus-vertx")
    implementation ("io.quarkus:quarkus-resteasy-mutiny")
    implementation ("io.quarkus:quarkus-hibernate-orm")
    implementation ("io.quarkus:quarkus-hibernate-validator")
    compile ("io.vertx:vertx-pg-client:4.2.2")
    testImplementation ("io.quarkus:quarkus-junit5")
    testImplementation ("io.rest-assured:rest-assured")
}

group = "com.bill"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

allOpen {
    annotation("javax.ws.rs.Path")
    annotation("javax.persistence.Entity")
    annotation("javax.enterprise.context.ApplicationScoped")
    annotation("io.quarkus.test.junit.QuarkusTest")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
    kotlinOptions.javaParameters = true
}

//quarkus {
//    setOutputDirectory("$projectDir/build/classes/kotlin/main")
//}
//
//quarkusDev {
//    setSourceDir("$projectDir/src/main/kotlin")
//}
