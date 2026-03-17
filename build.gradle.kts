plugins {
    id("com.gtnewhorizons.gtnhconvention")
}

tasks.test.configure {
    useJUnitPlatform()
    testLogging {
        events ("passed", "skipped", "failed")
    }
}

configurations {
    testImplementation.get().extendsFrom(compileOnly.get())
}

// Allow optional lwjgl3 usage, make sure to hide it behind the appropriate conditionals
// This can't be in dependencies.gradle due to need to freeze the lwjgl3 version property
val lwjgl3Version = project.minecraft.lwjgl3Version.get()!!
dependencies {
    compileOnly("org.lwjgl:lwjgl-sdl:${lwjgl3Version}") { isTransitive = false }
    compileOnly("org.lwjgl:lwjgl:${lwjgl3Version}") { isTransitive = false }
    compileOnly("com.github.GTNewHorizons:lwjgl3ify:3.0.3:dev") { isTransitive = false }
}
