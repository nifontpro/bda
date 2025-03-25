plugins {
	alias(libs.plugins.bds.android.feature.ui)
}

android {
	namespace = "ru.nb.bds.run.presenter"
}

dependencies {
	implementation(projects.core.domain)
	implementation(projects.run.domain)

	implementation(libs.coil.compose)
	implementation(libs.google.maps.android.compose)
	implementation(libs.androidx.activity.compose)
	implementation(libs.timber)
}