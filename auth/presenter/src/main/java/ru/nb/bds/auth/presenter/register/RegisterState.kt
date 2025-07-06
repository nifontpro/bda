package ru.nb.bds.auth.presenter.register

import androidx.compose.foundation.text.input.TextFieldState
import ru.nb.bds.auth.domain.PasswordValidationState

data class RegisterState(
	val email: TextFieldState = TextFieldState(),
	val isEmailValid: Boolean = false,
	val password: TextFieldState = TextFieldState(),
	val isPasswordVisible: Boolean = false,
	val passwordValidationState: PasswordValidationState = PasswordValidationState(),
	val isRegistering: Boolean = false,
	val canRegister: Boolean = false
)
