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

    val pitestVersion = "1.15.0"
    val mysqlVersion = "8.0.32"
    val jacksonVersion = "2.15.2"
    val springbootstarterVersion = "3.1.2"
    val springfoxVersion = "3.0.0"
    val springbootstarterSecurityVersion = "3.1.4"
    val slf4jVersion = "1.7.32"
    val logbackVersion = "1.2.9"
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.pitest:pitest:$pitestVersion")
    implementation("mysql:mysql-connector-java:$mysqlVersion")
    implementation("com.fasterxml.jackson.core:jackson-annotations:$jacksonVersion")
    implementation("org.springframework.boot:spring-boot-starter:$springbootstarterVersion")
    implementation("io.springfox:springfox-boot-starter:$springfoxVersion")
    implementation("io.springfox:springfox-swagger2:$springfoxVersion")
    implementation("io.springfox:springfox-swagger-ui:$springfoxVersion")
    implementation("org.springframework.boot:spring-boot-starter-security:$springbootstarterSecurityVersion")
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    val lombokVersion = "1.18.28"
    val junit5Version = "1.2.0"
    val kotlintestVersion = "1.9.10"
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    runtimeOnly("com.h2database:h2")
    pitest("org.pitest:pitest-junit5-plugin:$junit5Version")
    testAnnotationProcessor("org.projectlombok:lombok:$lombokVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:$kotlintestVersion")
    testCompileOnly("org.projectlombok:lombok:$lombokVersion")
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

allprojects {
    sonarqube {
        properties {
            property("sonar.recursoshumanos", "yms-gate")
            property("sonar.coverage.jacoco.xmlReportPaths", "**/build/reports/jacoco/test/jacocoTestReport.xml")
        }
    }
}

pitest {
    junit5PluginVersion.set("1.0.0")
    mutators.set(setOf("STRONGER"))
    outputFormats.set(setOf("XML", "HTML"))
    excludedClasses.set(setOf("*.config.*", "*.dto.*", "*.persistencia.*"))
}
