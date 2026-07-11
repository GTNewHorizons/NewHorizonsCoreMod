import com.gtnewhorizons.retrofuturagradle.minecraft.RunMinecraftTask

plugins {
    id("com.gtnewhorizons.gtnhconvention")
}

// Forwarded for headless census boots (RunMinecraftTask does not copy arbitrary -D flags from the
// Gradle JVM); mirrors the same block in GT5-Unofficial's build.gradle.kts.
tasks.named<RunMinecraftTask>("runServer").configure {
    if (System.getProperty("gt.dumpMaterialData") != null) {
        jvmArgs("-Dgt.dumpMaterialData=true")
    }
    System.getProperty("fml.queryResult")?.let {
        jvmArgs("-Dfml.queryResult=$it")
    }
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
    compileOnly("com.github.GTNewHorizons:lwjgl3ify:3.0.24:dev") { isTransitive = false }
}
