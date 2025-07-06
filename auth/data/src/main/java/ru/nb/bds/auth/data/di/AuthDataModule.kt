package ru.nb.bds.auth.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.nb.bds.auth.data.AuthRepositoryImpl
import ru.nb.bds.auth.data.EmailPatternValidator
import ru.nb.bds.auth.domain.AuthRepository
import ru.nb.bds.auth.domain.PatternValidator
import ru.nb.bds.auth.domain.UserDataValidator

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}