package ru.nb.birthdays

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.nb.bds.auth.data.di.authDataModule
import ru.nb.bds.auth.presenter.di.authViewModelModule
import ru.nb.bds.core.data.BuildConfig
import ru.nb.bds.core.data.di.coreDataModule
import ru.nb.birthdays.di.appModule
import timber.log.Timber

class BirthdaysApp : Application() {

	override fun onCreate() {
		super.onCreate()
		if (BuildConfig.DEBUG) {
			Timber.plant(Timber.DebugTree())
		}

		startKoin {
			androidLogger()
			androidContext(this@BirthdaysApp)
			modules(
				authDataModule,
				authViewModelModule,
				appModule,
				coreDataModule
			)
		}
	}
}