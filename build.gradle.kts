plugins {
    java
    id("org.springframework.boot") version "2.7.15"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    jacoco
    id("org.sonarqube") version "4.4.1.3373"
}

group = "co.empresa"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("mysql:mysql-connector-java:8.0.32")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.15.2")
    implementation("org.springframework.boot:spring-boot-starter:3.1.2")
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("io.springfox:springfox-swagger2:3.0.0")
    implementation("io.springfox:springfox-swagger-ui:3.0.0")
    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")
    testCompileOnly("org.projectlombok:lombok:1.18.28")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.28")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        csv.required.set(true)
    }

}
jacoco {
    toolVersion = "0.8.8"
}

sonarqube {

    properties {

        property("sonar.recursoshumanos", "yms-gate")

    }

}