package ru.nb.bds.auth.presenter.register

sealed interface RegisterAction {
	data object OnTogglePasswordVisibilityClick : RegisterAction
	data object OnLoginClick : RegisterAction
	data object OnRegisterClick : RegisterAction
}