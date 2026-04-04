package com.personal.endpointmobile.domain.repository

import com.personal.endpointmobile.core.utils.Resource
import com.personal.endpointmobile.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val currentUser: User?
    val isLoggedIn: Boolean

    suspend fun signIn(email: String, password: String): Resource<User>
    suspend fun signUp(email: String, password: String, displayName: String): Resource<User>
    suspend fun signOut()
    suspend fun resetPassword(email: String): Resource<Unit>
    fun observeAuthState(): Flow<User?>
}
