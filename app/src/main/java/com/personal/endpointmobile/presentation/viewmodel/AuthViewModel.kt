package com.personal.endpointmobile.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personal.endpointmobile.core.utils.Resource
import com.personal.endpointmobile.domain.model.User
import com.personal.endpointmobile.domain.repository.AuthRepository
import com.personal.endpointmobile.domain.usecase.auth.SignInUseCase
import com.personal.endpointmobile.domain.usecase.auth.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val signUpUseCase: SignUpUseCase,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _authState = MutableStateFlow<Resource<User>?>(null)
    val authState: StateFlow<Resource<User>?> = _authState.asStateFlow()

    val isLoggedIn get() = authRepository.isLoggedIn
    val currentUser get() = authRepository.currentUser

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = Resource.Loading
            _authState.value = signInUseCase(email, password)
        }
    }

    fun signUp(email: String, password: String, displayName: String) {
        viewModelScope.launch {
            _authState.value = Resource.Loading
            _authState.value = signUpUseCase(email, password, displayName)
        }
    }

    fun signOut() {
        viewModelScope.launch {
            authRepository.signOut()
            _authState.value = null
        }
    }

    fun resetState() {
        _authState.value = null
    }
}
