plugins {
	alias(libs.plugins.bds.android.library.compose)
}

android {
	namespace = "ru.nb.bds.core.presenter.ui"
}

dependencies {
	implementation(projects.core.domain)
	implementation(projects.core.presenter.design)

	implementation(libs.bundles.compose)
}