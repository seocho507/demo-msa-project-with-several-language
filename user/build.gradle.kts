plugins {
    java
    id("org.springframework.boot") version "3.3.5"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "com.seocho507"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.postgresql:postgresql")

    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt-api:0.12.6")
    implementation("io.jsonwebtoken:jjwt-impl:0.12.6")
    implementation("io.jsonwebtoken:jjwt-jackson:0.12.6")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }

    withType<org.springframework.boot.gradle.tasks.run.BootRun> {
        systemProperty("spring.profiles.active", "dev")
    }

    register<Exec>("dockerBuild") {
        dependsOn("build")
        commandLine("docker", "build", "-t", "user-service:latest", ".")
        environment("SPRING_PROFILES_ACTIVE", "prod")
    }

    withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
        archiveBaseName.set("user-service")
        archiveVersion.set("")
    }
}