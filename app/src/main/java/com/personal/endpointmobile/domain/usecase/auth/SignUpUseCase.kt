package com.personal.endpointmobile.domain.usecase.auth

import com.personal.endpointmobile.core.utils.Resource
import com.personal.endpointmobile.domain.model.User
import com.personal.endpointmobile.domain.repository.AuthRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String,
        displayName: String
    ): Resource<User> {
        if (email.isBlank()) return Resource.Error("Email cannot be empty")
        if (password.length < 6) return Resource.Error("Password must be at least 6 characters")
        if (displayName.isBlank()) return Resource.Error("Display name cannot be empty")
        return authRepository.signUp(email.trim(), password, displayName.trim())
    }
}
