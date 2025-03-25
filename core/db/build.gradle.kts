plugins {
	alias(libs.plugins.bds.android.library)
	alias(libs.plugins.bds.android.room)
}

android {
	namespace = "ru.nb.bds.core.db"
}

dependencies {
	implementation(libs.org.mongodb.bson)
	implementation(libs.bundles.koin)

	implementation(projects.core.domain)
}