import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import ru.nb.bds.convention.configureAndroidCompose

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {

	override fun apply(target: Project) {
		target.run {
			pluginManager.apply("bds.android.application")
			pluginManager.apply("org.jetbrains.kotlin.plugin.compose")

			val extension = extensions.getByType<ApplicationExtension>()
			configureAndroidCompose(extension)
		}
	}
}