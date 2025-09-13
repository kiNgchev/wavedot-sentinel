plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(libs.kotlin)
    implementation(plugin(libs.plugins.kover))
    implementation(plugin(libs.plugins.dokka))
    implementation(plugin(libs.plugins.animalsniffer))
    implementation(plugin(libs.plugins.binaryCompatibilityValidator))
    implementation(plugin(libs.plugins.knit))
    implementation(plugin(libs.plugins.jmh))
    implementation(plugin(libs.plugins.shadow))
}

kotlin {
    compilerOptions {
        allWarningsAsErrors = true
    }
}

fun DependencyHandlerScope.plugin(plugin: Provider<PluginDependency>) =
    plugin.map { "${it.pluginId}:${it.pluginId}.gradle.plugin:${it.version}" }