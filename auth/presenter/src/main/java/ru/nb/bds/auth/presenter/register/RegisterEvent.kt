package ru.nb.bds.auth.presenter.register

import ru.nb.bds.core.presenter.ui.UiText

sealed interface RegisterEvent {
	data object RegistrationSuccess : RegisterEvent
	data class Error(val error: UiText) : RegisterEvent
}