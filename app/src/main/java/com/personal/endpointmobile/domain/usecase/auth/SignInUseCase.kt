package com.personal.endpointmobile.domain.usecase.auth

import com.personal.endpointmobile.core.utils.Resource
import com.personal.endpointmobile.domain.model.User
import com.personal.endpointmobile.domain.repository.AuthRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): Resource<User> {
        if (email.isBlank()) return Resource.Error("Email cannot be empty")
        if (password.isBlank()) return Resource.Error("Password cannot be empty")
        return authRepository.signIn(email.trim(), password)
    }
}
