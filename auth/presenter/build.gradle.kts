plugins {
	alias(libs.plugins.bds.android.feature.ui)
}

android {
	namespace = "ru.nb.bds.auth.presenter"
}

dependencies {
	implementation(projects.core.domain)
	implementation(projects.auth.domain)
}