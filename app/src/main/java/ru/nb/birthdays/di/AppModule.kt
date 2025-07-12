package ru.nb.birthdays.di

import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.nb.birthdays.MainViewModel

val appModule = module {
    single<SharedPreferences> {
        EncryptedSharedPreferences(
            androidApplication(),
            "auth_pref",
            MasterKey(androidApplication()),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    viewModelOf(::MainViewModel)
}