package ru.nb.bds.auth.domain

interface PatternValidator {
	fun matches(value: String): Boolean
}