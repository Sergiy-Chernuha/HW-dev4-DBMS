plugins {
    id ("java")
    id("org.flywaydb.flyway") version "9.20.1"
}

group = "ua.goit"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.postgresql:postgresql:42.6.0")
    implementation("org.slf4j:slf4j-api:2.0.7")
    implementation("org.flywaydb:flyway-maven-plugin:9.20.1")
}

flyway{
    configFiles = arrayOf("src/main/java/resources/flyway.conf")
}
