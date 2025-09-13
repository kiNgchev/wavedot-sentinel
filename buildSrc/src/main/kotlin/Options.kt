import kotlinx.validation.ApiValidationExtension
import org.gradle.api.NamedDomainObjectSet
import org.gradle.api.Project
import org.gradle.kotlin.dsl.invoke
import org.jetbrains.dokka.gradle.DokkaExtension
import org.jetbrains.dokka.gradle.workers.ProcessIsolation
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinCommonCompilerOptions
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

internal val sentinelOptIns = listOf(
    "kotlin.contracts.ExperimentalContracts"
)

internal fun ApiValidationExtension.bvcOptions() {
}

internal fun KotlinCommonCompilerOptions.commonCompilerOptions() {
    allWarningsAsErrors.set(true)
    progressiveMode.set(true)
    freeCompilerArgs.add("-Xexpect-actual-classes")
}

internal fun KotlinJvmCompilerOptions.jvmCompilerOptions() {
    commonCompilerOptions()
    jvmTarget.set(JvmTarget.JVM_1_8)
    freeCompilerArgs.add("-Xjdk-release=1.8")
}

internal fun NamedDomainObjectSet<KotlinSourceSet>.testOptIns() {
    named { it.contains("test", ignoreCase = true) }.configureEach {
        languageSettings.optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
    }
}

internal fun DokkaExtension.dokkaOptions(project: Project) {

    (dokkaGeneratorIsolation.get() as? ProcessIsolation)?.maxHeapSize?.set("1g")

    moduleName.set(project.name)

    dokkaPublications.configureEach {
        failOnWarning.set(true)
    }

    dokkaSourceSets.configureEach {

        jdkVersion.set(21)

        suppressGeneratedFiles.set(false)

        externalDocumentationLinks {
            register("kotlinx.coroutines") {
                url("https://kotlinlang.org/api/kotlinx.coroutines/")
            }
        }
    }
}