pluginManagement {
	includeBuild("build-logic")
	repositories {
		google()
		mavenCentral()
		gradlePluginPortal()
	}
}
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		google()
		mavenCentral()
	}
}

gradle.startParameter.excludedTaskNames.addAll(listOf(":build-logic:convention:testClasses"))

rootProject.name = "Birthdays"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")
include(":auth:data")
include(":auth:domain")
include(":auth:presenter")
include(":core:presenter:design")
include(":core:presenter:ui")
include(":core:domain")
include(":core:data")
include(":core:db")
include(":run:data")
include(":run:presenter")
include(":run:domain")
include(":run:location")
include(":run:net")
