package ru.nb.bds.auth.data

import io.ktor.client.HttpClient
import ru.nb.bds.auth.domain.AuthRepository
import ru.nb.bds.core.data.networking.post
import ru.nb.bds.core.domain.util.DataError
import ru.nb.bds.core.domain.util.EmptyResult

class AuthRepositoryImpl(
    private val httpClient: HttpClient
) : AuthRepository {

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/auth/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}