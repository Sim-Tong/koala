plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION
    kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
    kotlin("plugin.jpa") version PluginVersions.JPA_PLUGIN_VERSION
}

dependencies {
    implementation(Dependencies.SPRING_SECURITY)
    implementation(Dependencies.SPRING_VALIDATION)

    implementation(Dependencies.JACKSON)

    implementation(Dependencies.SPRING_DATA_JPA)
    runtimeOnly(Dependencies.MYSQL_CONNECTOR)

    implementation(Dependencies.JWT)

    implementation(Dependencies.MAPSTRUCT_PROCESSER)
    implementation(Dependencies.MAPSTRUCT)

    implementation(Dependencies.SPRING_AWS)
    annotationProcessor(Dependencies.CONFIGURATION_PROCESSOR)

    api(project(":koala-application"))
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

tasks.getByName<Jar>("bootJar") {
    enabled = false
}