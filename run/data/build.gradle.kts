plugins {
	alias(libs.plugins.bds.android.library)
}

android {
	namespace = "ru.nb.bds.run.data"
}

dependencies {
	implementation(projects.core.domain)
	implementation(projects.core.db)
	implementation(projects.run.domain)
}