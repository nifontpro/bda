package ru.nb.bds.core.data.auth

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.nb.bds.core.domain.AuthInfo
import ru.nb.bds.core.domain.SessionStorage

class EncryptedSessionStorage(
	private val sharedPreferences: SharedPreferences
) : SessionStorage {

	override suspend fun get(): AuthInfo? {
		return withContext(Dispatchers.IO) {
			val json = sharedPreferences.getString(KEY_AUTH_INFO, null)
			json?.let {
				Json.decodeFromString<AuthInfoSerializable>(it).toAuthInfo()
			}
		}
	}

	override suspend fun set(info: AuthInfo?) {
		withContext(Dispatchers.IO) {
			if (info == null) {
				sharedPreferences.edit(commit = true) {
					remove(KEY_AUTH_INFO)
				}
				return@withContext
			}

			val json = Json.encodeToString(info.toAuthInfoSerializable())
			sharedPreferences
				.edit(commit = true) {
					putString(KEY_AUTH_INFO, json)
				}
		}
	}

	companion object {
		private const val KEY_AUTH_INFO = "KEY_AUTH_INFO"
	}
}