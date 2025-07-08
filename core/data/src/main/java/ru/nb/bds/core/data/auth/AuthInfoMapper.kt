package ru.nb.bds.core.data.auth

import ru.nb.bds.core.domain.AuthInfo

fun AuthInfo.toAuthInfoSerializable(): AuthInfoSerializable {
	return AuthInfoSerializable(
		accessToken = accessToken,
		refreshToken = refreshToken,
	)
}

fun AuthInfoSerializable.toAuthInfo(): AuthInfo {
	return AuthInfo(
		accessToken = accessToken,
		refreshToken = refreshToken,
	)
}