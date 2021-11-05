pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "sample"

include(":shared")

includeBuild("..") {
    dependencySubstitution {
        listOf("annotations", "compiler", "core", "gradle-plugin").forEach {
            substitute(module("com.rickclephas.kmp:kmp-nativecoroutines-$it"))
                .using(project(":kmp-nativecoroutines-$it"))
        }
    }
}
