plugins {
	alias(libs.plugins.bds.android.library)
}

android {
	namespace = "ru.nb.bds.run.location"

}

dependencies {
	implementation(projects.core.domain)
	implementation(projects.run.domain)
}