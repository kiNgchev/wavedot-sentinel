import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.targets.js.testing.KotlinJsTest

plugins {
    org.jetbrains.kotlin.multiplatform
    org.jetbrains.kotlin.plugin.serialization
    org.jetbrains.kotlinx.`binary-compatibility-validator`
    org.jetbrains.dokka
}

repositories {
    mavenCentral()
}

val libs = the<VersionCatalogsExtension>().named("libs")

dependencies {
    commonMainImplementation(libs.findLibrary("kotlin-serialization-core").get())
    commonMainImplementation(libs.findLibrary("kotlin-serialization-json").get())
    commonTestImplementation(kotlin("test"))
}

kotlin {
    explicitApi()

    compilerOptions {
        commonCompilerOptions()
        optIn.addAll(sentinelOptIns)
    }
    jvm {
        compilerOptions {
            jvmCompilerOptions()
        }
    }
    js {
        nodejs()
        useCommonJs()
        generateTypeScriptDefinitions()
        binaries.library()
    }

    applyDefaultHierarchyTemplate()
}

apiValidation {
    bvcOptions()
}

tasks {
    withType<Test>().configureEach {
        useJUnitPlatform()
    }

    withType<KotlinJsTest>().configureEach {
        environment("PROJECT_ROOT", rootProject.projectDir.absolutePath)
    }
}

