plugins {
	alias(libs.plugins.bds.android.application.compose)
	alias(libs.plugins.bds.jvm.ktor)
}

android {
	namespace = "ru.nb.bds"

	defaultConfig {
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}

	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
//	dynamicFeatures += setOf(":analytics:analytics_feature")
}

dependencies {
	// Coil
	implementation(libs.coil.compose)

	// Compose
	implementation(libs.androidx.activity.compose)
	implementation(libs.androidx.material.icons.extended)
	implementation(libs.androidx.compose.ui)
	implementation(libs.androidx.compose.ui.graphics)
	implementation(libs.androidx.compose.ui.tooling.preview)
	implementation(libs.androidx.compose.material3)
	implementation(libs.androidx.lifecycle.viewmodel.compose)
	implementation(libs.androidx.lifecycle.runtime.compose)
	implementation(libs.androidx.navigation.compose)

	// Core
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)

	// Crypto
	implementation(libs.androidx.security.crypto.ktx)

	implementation(libs.bundles.koin)

	api(libs.play.feature.delivery)
	api(libs.play.feature.delivery.ktx)

	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(libs.androidx.compose.ui.test.junit4)
	debugImplementation(libs.androidx.compose.ui.tooling)
	debugImplementation(libs.androidx.compose.ui.test.manifest)

	// Location
	implementation(libs.google.android.gms.play.services.location)

	// Splash screen
	implementation(libs.androidx.core.splashscreen)

	// Timber
	implementation(libs.timber)

	implementation(projects.core.presenter.design)
	implementation(projects.core.presenter.ui)
	implementation(projects.core.domain)
	implementation(projects.core.data)
	implementation(projects.core.db)
//	implementation(projects.core.notification)

	implementation(projects.auth.presenter)
	implementation(projects.auth.domain)
	implementation(projects.auth.data)

	implementation(projects.run.presenter)
	implementation(projects.run.domain)
	implementation(projects.run.data)
	implementation(projects.run.location)
	implementation(projects.run.net)

//	implementation(projects.core.connectivity.domain)
//	implementation(projects.core.connectivity.data)
}
