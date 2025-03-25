plugins {
	alias(libs.plugins.bds.android.library)
	alias(libs.plugins.bds.jvm.ktor)
}

android {
	namespace = "ru.nb.bds.core.data"
}

dependencies {
	implementation(libs.timber)
	implementation(libs.bundles.koin)

	implementation(projects.core.domain)
	implementation(projects.core.db)
}