plugins {
    id("kotlin-conventions")
}

val libs = the<VersionCatalogsExtension>().named("libs")

dependencies {
    commonMainImplementation(libs.findLibrary("ktor-client-core").get())
    commonMainImplementation(libs.findLibrary("ktor-client-cio").get())
}