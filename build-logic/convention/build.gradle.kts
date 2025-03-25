plugins {
	`kotlin-dsl`
}

group = "ru.nb.bds.buildlogic"

dependencies {
	compileOnly(libs.android.gradlePlugin)
	compileOnly(libs.android.tools.common)
	compileOnly(libs.kotlin.gradlePlugin)
	compileOnly(libs.ksp.gradlePlugin)
	compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
	plugins {
		register("androidApplication") {
			id = "bds.android.application"
			implementationClass = "AndroidApplicationConventionPlugin"
		}
		register("androidApplicationCompose") {
			id = "bds.android.application.compose"
			implementationClass = "AndroidApplicationComposeConventionPlugin"
		}
		register("androidLibrary") {
			id = "bds.android.library"
			implementationClass = "AndroidLibraryConventionPlugin"
		}
		register("androidLibraryCompose") {
			id = "bds.android.library.compose"
			implementationClass = "AndroidLibraryComposeConventionPlugin"
		}
		register("androidFeatureUi") {
			id = "bds.android.feature.ui"
			implementationClass = "AndroidFeatureUiConventionPlugin"
		}
		register("androidRoom") {
			id = "bds.android.room"
			implementationClass = "AndroidRoomConventionPlugin"
		}
//		register("androidDynamicFeature") {
//			id = "bds.android.dynamic.feature"
//			implementationClass = "AndroidDynamicFeatureConventionPlugin"
//		}
		register("jvmLibrary") {
			id = "bds.jvm.library"
			implementationClass = "JvmLibraryConventionPlugin"
		}
		register("jvmKtor") {
			id = "bds.jvm.ktor"
			implementationClass = "JvmKtorConventionPlugin"
		}
	}
}