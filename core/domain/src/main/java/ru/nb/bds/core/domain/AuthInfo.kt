package ru.nb.bds.core.domain

data class AuthInfo(
    val accessToken: String,
    val refreshToken: String,
)
