package com.personal.endpointmobile.data.repository

import com.personal.endpointmobile.core.utils.Resource
import com.personal.endpointmobile.domain.model.User
import com.personal.endpointmobile.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class FakeAuthRepository @Inject constructor() : AuthRepository {

    private val authState = MutableStateFlow<User?>(null)

    override val currentUser: User? get() = authState.value
    override val isLoggedIn: Boolean get() = authState.value != null

    override suspend fun signIn(email: String, password: String): Resource<User> {
        if (email != "admin" || password != "1234") {
            return Resource.Error("Invalid username or password")
        }
        val user = User(uid = "fake-uid-001", email = email, displayName = "Admin")
        authState.value = user
        return Resource.Success(user)
    }

    override suspend fun signUp(email: String, password: String, displayName: String): Resource<User> {
        val user = User(uid = "fake-uid", email = email, displayName = displayName)
        authState.value = user
        return Resource.Success(user)
    }

    override suspend fun signOut() {
        authState.value = null
    }

    override suspend fun resetPassword(email: String): Resource<Unit> =
        Resource.Success(Unit)

    override fun observeAuthState(): Flow<User?> = authState
}
