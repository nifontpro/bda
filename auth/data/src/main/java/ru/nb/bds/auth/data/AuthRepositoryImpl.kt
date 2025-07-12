package ru.nb.bds.auth.data

import io.ktor.client.HttpClient
import ru.nb.bds.auth.domain.AuthRepository
import ru.nb.bds.core.data.networking.post
import ru.nb.bds.core.domain.AuthInfo
import ru.nb.bds.core.domain.SessionStorage
import ru.nb.bds.core.domain.util.DataError
import ru.nb.bds.core.domain.util.EmptyResult
import ru.nb.bds.core.domain.util.Result
import ru.nb.bds.core.domain.util.asEmptyDataResult

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage,
) : AuthRepository {

    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/auth/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )
        if (result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                )
            )
        }
        return result.asEmptyDataResult()
    }

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