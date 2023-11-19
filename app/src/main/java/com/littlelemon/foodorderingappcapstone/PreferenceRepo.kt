package com.littlelemon.foodorderingappcapstone

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.withContext

class PreferenceRepo(context: Context) {
    val userInfo = context.getSharedPreferences(userInfoKeyFile, Context.MODE_PRIVATE)

    companion object {
        const val userInfoKeyFile = "user_info"
        const val userFirstName ="user_firstname"
        const val userLastName = "user_lastname"
        const val userEmail = "user_email"
        const val isUserLoggedIn = "user_login"

        var instance: PreferenceRepo? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getPreferenceRepo(context: Context): PreferenceRepo {
            if(instance == null) {
                synchronized(this) {
                    instance = PreferenceRepo(context)
                }
            }
            return instance!!
        }
    }

    suspend fun saveUser(user: User): Boolean = withContext(Dispatchers.IO) {
        with(userInfo.edit()) {

            putString(userFirstName, user.firstName)
            putString(userLastName, user.lastName)
            putString(userEmail, user.email)

            if (commit()) {
                putBoolean(isUserLoggedIn, true)
                apply()
                return@withContext true
            } else return@withContext false
        }
    }

    fun isUserLoggedIn(): Boolean {
        return userInfo.getBoolean(isUserLoggedIn, false)
    }

    fun getUser() = flow {
        emit(
            User(
                firstName = userInfo.getString(userFirstName, "") ?: return@flow,
                lastName = userInfo.getString(userLastName, "") ?: return@flow,
                email = userInfo.getString(userEmail, "") ?: return@flow
            )
        )
    }

    suspend fun clearUser(): Boolean = withContext(Dispatchers.IO) {
        with(userInfo.edit()) {
            clear()
            return@with commit()
        }
    }
}