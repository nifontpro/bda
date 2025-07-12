package ru.nb.bds.auth.domain

import ru.nb.bds.core.domain.util.DataError
import ru.nb.bds.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}