package ru.nb.bds.auth.presenter.login

import ru.nb.bds.core.presenter.ui.UiText

sealed interface LoginEvent {
    data class Error(val error: UiText): LoginEvent
    data object LoginSuccess: LoginEvent
}