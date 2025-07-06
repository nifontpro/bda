package ru.nb.bds.auth.data

import android.util.Patterns
import ru.nb.bds.auth.domain.PatternValidator

object EmailPatternValidator : PatternValidator {

	override fun matches(value: String): Boolean {
		return Patterns.EMAIL_ADDRESS.matcher(value).matches()
	}
}