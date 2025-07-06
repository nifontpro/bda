plugins {
	alias(libs.plugins.bds.android.library)
	alias(libs.plugins.bds.jvm.ktor)
}

android {
	namespace = "ru.nb.bds.auth.data"
}

dependencies {
	implementation(projects.auth.domain)
	implementation(projects.core.domain)
	implementation(projects.core.data)

	implementation(libs.bundles.koin)
}