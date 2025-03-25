plugins {
	alias(libs.plugins.bds.jvm.library)
}

dependencies {
	implementation(projects.core.domain)

	implementation(libs.kotlinx.coroutines.core)
}