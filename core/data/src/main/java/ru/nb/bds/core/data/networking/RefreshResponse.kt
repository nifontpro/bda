package ru.nb.bds.core.data.networking

import kotlinx.serialization.Serializable

@Serializable
data class RefreshResponse(
    val accessToken: String,
    val expirationTimestamp: Long
)
