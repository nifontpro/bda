package ru.nb.bds.core.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.nb.bds.core.data.auth.EncryptedSessionStorage
import ru.nb.bds.core.data.networking.HttpClientFactory
import ru.nb.bds.core.domain.SessionStorage

val coreDataModule = module {
	single {
		HttpClientFactory().build()
	}
	singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}