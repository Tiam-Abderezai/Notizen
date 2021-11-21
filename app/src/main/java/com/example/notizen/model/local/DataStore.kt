package com.example.notizen.model.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class DataStore(val context: Context) {
    companion object {
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token_store")
    }
    private val jwt = stringPreferencesKey("token_key")


    suspend fun setToken(jwt: String) {
        context.dataStore.edit { preferences ->
            preferences[this.jwt] = jwt
        }
    }

    suspend fun getToken(): String? {
        return context.dataStore.data.map {
            it[jwt]
        }.first()
    }
}