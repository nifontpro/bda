@file:OptIn(ExperimentalFoundationApi::class)

package ru.nb.bds.auth.presenter.register

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.koinViewModel
import ru.nb.bds.auth.domain.PasswordValidationState
import ru.nb.bds.auth.domain.UserDataValidator
import ru.nb.bds.auth.presenter.R
import ru.nb.bds.core.presenter.design.BirthdaysTheme
import ru.nb.bds.core.presenter.design.CheckIcon
import ru.nb.bds.core.presenter.design.CrossIcon
import ru.nb.bds.core.presenter.design.EmailIcon
import ru.nb.bds.core.presenter.design.Poppins
import ru.nb.bds.core.presenter.design.RuniqueDarkRed
import ru.nb.bds.core.presenter.design.RuniqueGreen
import ru.nb.bds.core.presenter.design.component.GradientBackground
import ru.nb.bds.core.presenter.design.component.RuniqueActionButton
import ru.nb.bds.core.presenter.design.component.RuniquePasswordTextField
import ru.nb.bds.core.presenter.design.component.RuniqueTextField
import ru.nb.bds.core.presenter.ui.ObserveAsEvents

@Composable
fun RegisterScreenRoot(
	onSignInClick: () -> Unit,
	onSuccessfulRegistration: () -> Unit,
	viewModel: RegisterViewModel = koinViewModel(),
) {
	val context = LocalContext.current
	val keyboardController = LocalSoftwareKeyboardController.current
	ObserveAsEvents(viewModel.events) { event ->
		when (event) {
			is RegisterEvent.Error -> {
				keyboardController?.hide()
				Toast.makeText(
					context,
					event.error.asString(context),
					Toast.LENGTH_LONG
				).show()
			}

			RegisterEvent.RegistrationSuccess -> {
				keyboardController?.hide()
				Toast.makeText(
					context,
					R.string.registration_successful,
					Toast.LENGTH_LONG
				).show()
				onSuccessfulRegistration()
			}
		}
	}

	RegisterScreen(
		state = viewModel.state,
		onAction = { action ->
			when (action) {
				RegisterAction.OnLoginClick -> onSignInClick()
				else -> Unit
			}
			viewModel.onAction(action)
		}
	)
}

@Composable
private fun RegisterScreen(
	state: RegisterState,
	onAction: (RegisterAction) -> Unit
) {
	GradientBackground {
		Column(
			modifier = Modifier
				.verticalScroll(rememberScrollState())
				.fillMaxSize()
				.padding(horizontal = 16.dp)
				.padding(vertical = 32.dp)
				.padding(top = 16.dp)
		) {
			Text(
				text = stringResource(id = R.string.create_account),
				style = MaterialTheme.typography.headlineMedium
			)
			val annotatedString = buildAnnotatedString {
				withStyle(
					style = SpanStyle(
						fontFamily = Poppins,
						color = MaterialTheme.colorScheme.onSurfaceVariant
					)
				) {
					append(stringResource(id = R.string.already_have_an_account) + " ")
					pushStringAnnotation(
						tag = "clickable_text",
						annotation = stringResource(id = R.string.login)
					)
					withStyle(
						style = SpanStyle(
							fontWeight = FontWeight.SemiBold,
							color = MaterialTheme.colorScheme.primary,
							fontFamily = Poppins
						)
					) {
						append(stringResource(id = R.string.login))
					}
				}
			}
			ClickableText(
				text = annotatedString,
				onClick = { offset ->
					annotatedString.getStringAnnotations(
						tag = "clickable_text",
						start = offset,
						end = offset
					).firstOrNull()?.let {
						onAction(RegisterAction.OnLoginClick)
					}
				}
			)
			Spacer(modifier = Modifier.height(48.dp))
			RuniqueTextField(
				state = state.email,
				startIcon = EmailIcon,
				endIcon = if (state.isEmailValid) {
					CheckIcon
				} else null,
				hint = stringResource(id = R.string.example_email),
				title = stringResource(id = R.string.email),
				modifier = Modifier.fillMaxWidth(),
				additionalInfo = stringResource(id = R.string.must_be_a_valid_email),
				keyboardType = KeyboardType.Email
			)
			Spacer(modifier = Modifier.height(16.dp))
			RuniquePasswordTextField(
				state = state.password,
				isPasswordVisible = state.isPasswordVisible,
				onTogglePasswordVisibility = {
					onAction(RegisterAction.OnTogglePasswordVisibilityClick)
				},
				hint = stringResource(id = R.string.password),
				title = stringResource(id = R.string.password),
				modifier = Modifier.fillMaxWidth()
			)
			Spacer(modifier = Modifier.height(16.dp))

			PasswordRequirement(
				text = stringResource(
					id = R.string.at_least_x_characters,
					UserDataValidator.MIN_PASSWORD_LENGTH
				),
				isValid = state.passwordValidationState.hasMinLength
			)
			Spacer(modifier = Modifier.height(4.dp))
			PasswordRequirement(
				text = stringResource(
					id = R.string.at_least_one_number,
				),
				isValid = state.passwordValidationState.hasNumber
			)
			Spacer(modifier = Modifier.height(4.dp))
			PasswordRequirement(
				text = stringResource(
					id = R.string.contains_lowercase_char,
				),
				isValid = state.passwordValidationState.hasLowerCaseCharacter
			)
			Spacer(modifier = Modifier.height(4.dp))
			PasswordRequirement(
				text = stringResource(
					id = R.string.contains_uppercase_char,
				),
				isValid = state.passwordValidationState.hasUpperCaseCharacter
			)
			Spacer(modifier = Modifier.height(32.dp))
			RuniqueActionButton(
				text = stringResource(id = R.string.register),
				isLoading = state.isRegistering,
				enabled = state.canRegister,
				modifier = Modifier.fillMaxWidth(),
				onClick = {
					onAction(RegisterAction.OnRegisterClick)
				}
			)
		}
	}
}

@Composable
fun PasswordRequirement(
	text: String,
	isValid: Boolean,
	modifier: Modifier = Modifier
) {
	Row(
		modifier = modifier,
		verticalAlignment = Alignment.CenterVertically
	) {
		Icon(
			imageVector = if (isValid) {
				CheckIcon
			} else {
				CrossIcon
			},
			contentDescription = null,
			tint = if (isValid) RuniqueGreen else RuniqueDarkRed
		)
		Spacer(modifier = Modifier.width(16.dp))
		Text(
			text = text,
			color = MaterialTheme.colorScheme.onSurfaceVariant,
			fontSize = 14.sp
		)
	}
}

@Preview
@Composable
private fun RegisterScreenPreview() {
	BirthdaysTheme {
		RegisterScreen(
			state = RegisterState(
				passwordValidationState = PasswordValidationState(
					hasNumber = true,
				)
			),
			onAction = {}
		)
	}
}