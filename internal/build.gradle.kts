plugins {
    `kotlin-conventions`
    `ktor-conventions`
}

kotlin {
    compilerOptions {
        optIn.add("space.wavedot.WavedotInternal")
    }
}