plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION
    kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
}

dependencies {
    implementation(Dependencies.SPRING_VALIDATION)
    implementation(Dependencies.SPRING_WEB)

    implementation(Dependencies.JACKSON)

    implementation(project(":koala-application"))
}

tasks.getByName<Jar>("jar") {
    enabled = false
}