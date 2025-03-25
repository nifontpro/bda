package ru.nb.bds.convention

import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

fun DependencyHandlerScope.addUiLayerDependencies(project: Project) {
	"implementation"(project(":core:presenter:ui"))
	"implementation"(project(":core:presenter:design"))

	"implementation"(project.libs.findBundle("koin.compose").get())
	"implementation"(project.libs.findBundle("compose").get())
	"debugImplementation"(project.libs.findBundle("compose.debug").get())
	"androidTestImplementation"(project.libs.findLibrary("androidx.compose.ui.test.junit4").get())
}