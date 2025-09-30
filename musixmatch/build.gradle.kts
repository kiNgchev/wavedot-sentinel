plugins {
    `kotlin-conventions`
    `ktor-conventions`
}

dependencies {
    commonMainImplementation(project(":internal"))
}