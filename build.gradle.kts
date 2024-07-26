plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"



repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("io.appium:java-client:7.6.0")
    testImplementation("org.aeonbits.owner:owner:1.0.12")

}

tasks.test {
    useJUnitPlatform()
}