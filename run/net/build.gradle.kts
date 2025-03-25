plugins {
	alias(libs.plugins.bds.android.library)
	alias(libs.plugins.bds.jvm.ktor)
}

android {
	namespace = "ru.nb.bds.run.net"

}

dependencies {
	implementation(libs.bundles.koin)

	implementation(projects.core.domain)
	implementation(projects.run.domain)
}