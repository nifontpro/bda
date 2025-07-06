package ru.nb.bds.auth.presenter.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.nb.bds.auth.presenter.register.RegisterViewModel

val authViewModelModule = module {
	viewModelOf(::RegisterViewModel)
}