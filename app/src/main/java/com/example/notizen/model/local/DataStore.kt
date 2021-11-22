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
        val Context.dataStore_token: DataStore<Preferences> by preferencesDataStore(name = "store_token")
        val Context.dataStore_username: DataStore<Preferences> by preferencesDataStore(name = "store_username")
        val Context.dataStore_email: DataStore<Preferences> by preferencesDataStore(name = "store_email")
        val Context.dataStore_password: DataStore<Preferences> by preferencesDataStore(name = "store_password")

    }
    private val token = stringPreferencesKey("key_token")
    private val username = stringPreferencesKey("key_username")
    private val email = stringPreferencesKey("key_password")
    private val password = stringPreferencesKey("key_password")

        // TOKEN
    suspend fun setToken(token: String) {
        context.dataStore_token.edit { preferences ->
            preferences[this.token] = token
        }
    }

    suspend fun getToken(): String? {
        return context.dataStore_token.data.map {
            it[token]
        }.first()
    }

    // USERNAME
    suspend fun setUsername(username: String) {
        context.dataStore_username.edit { preferences ->
            preferences[this.username] = username
        }
    }

    suspend fun getUsername(): String? {
        return context.dataStore_username.data.map {
            it[username]
        }.first()
    }

    // EMAIL
    suspend fun setEmail(email: String) {
        context.dataStore_email.edit { preferences ->
            preferences[this.email] = email
        }
    }

    suspend fun getEmail(): String? {
        return context.dataStore_email.data.map {
            it[email]
        }.first()
    }

    // PASSWORD
    suspend fun setPassword(password: String) {
        context.dataStore_password.edit { preferences ->
            preferences[this.password] = password
        }
    }

    suspend fun getPassword(): String? {
        return context.dataStore_password.data.map {
            it[password]
        }.first()
    }

}