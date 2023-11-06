plugins {
    java
    id("org.springframework.boot") version "2.7.15"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    id("org.sonarqube") version "4.4.1.3373"
    id("info.solidsoft.pitest") version "1.15.0"
    jacoco
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
    implementation("org.pitest:pitest:1.15.0")
    implementation("mysql:mysql-connector-java:8.0.32")
    runtimeOnly("com.h2database:h2")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.15.2")
    implementation("org.springframework.boot:spring-boot-starter:3.1.2")
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("io.springfox:springfox-swagger2:3.0.0")
    implementation("io.springfox:springfox-swagger-ui:3.0.0")
    implementation("org.springframework.boot:spring-boot-starter-security:3.1.4")

    annotationProcessor("org.projectlombok:lombok:1.18.28")
    compileOnly("org.projectlombok:lombok:1.18.28")
    runtimeOnly("com.h2database:h2")
    pitest("org.pitest:pitest-junit5-plugin:1.2.0")

    testAnnotationProcessor("org.projectlombok:lombok:1.18.28")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.9.10")
    testCompileOnly("org.projectlombok:lombok:1.18.28")
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
        xml.required.set(true)
    }
}

tasks.withType<JacocoReport> {

    classDirectories.setFrom(sourceSets.main.get().output.asFileTree.matching {
        exclude("**/config/**")
        exclude("**/dto/**")
        exclude("**/persistencia/**")
        exclude("**/UserController")
    })
}



jacoco {
    toolVersion = "0.8.8"
}

sonarqube {

    properties {
        property("sonar.recursoshumanos", "yms-gate")
    }
}

pitest {
    junit5PluginVersion.set("1.0.0")
    mutators.set(setOf("STRONGER"))
    outputFormats.set(setOf("XML", "HTML"))
    excludedClasses.set(setOf("*.config.*", "*.dto.*", "*.persistencia.*"))
}