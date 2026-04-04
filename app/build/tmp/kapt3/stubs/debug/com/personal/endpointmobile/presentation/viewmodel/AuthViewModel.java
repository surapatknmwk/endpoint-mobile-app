package com.personal.endpointmobile.presentation.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u0018J\u001e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001bR\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/personal/endpointmobile/presentation/viewmodel/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "signInUseCase", "Lcom/personal/endpointmobile/domain/usecase/auth/SignInUseCase;", "signUpUseCase", "Lcom/personal/endpointmobile/domain/usecase/auth/SignUpUseCase;", "authRepository", "Lcom/personal/endpointmobile/domain/repository/AuthRepository;", "(Lcom/personal/endpointmobile/domain/usecase/auth/SignInUseCase;Lcom/personal/endpointmobile/domain/usecase/auth/SignUpUseCase;Lcom/personal/endpointmobile/domain/repository/AuthRepository;)V", "_authState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/personal/endpointmobile/core/utils/Resource;", "Lcom/personal/endpointmobile/domain/model/User;", "authState", "Lkotlinx/coroutines/flow/StateFlow;", "getAuthState", "()Lkotlinx/coroutines/flow/StateFlow;", "currentUser", "getCurrentUser", "()Lcom/personal/endpointmobile/domain/model/User;", "isLoggedIn", "", "()Z", "resetState", "", "signIn", "email", "", "password", "signOut", "signUp", "displayName", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.personal.endpointmobile.domain.usecase.auth.SignInUseCase signInUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personal.endpointmobile.domain.usecase.auth.SignUpUseCase signUpUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personal.endpointmobile.domain.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.personal.endpointmobile.core.utils.Resource<com.personal.endpointmobile.domain.model.User>> _authState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.personal.endpointmobile.core.utils.Resource<com.personal.endpointmobile.domain.model.User>> authState = null;
    
    @javax.inject.Inject()
    public AuthViewModel(@org.jetbrains.annotations.NotNull()
    com.personal.endpointmobile.domain.usecase.auth.SignInUseCase signInUseCase, @org.jetbrains.annotations.NotNull()
    com.personal.endpointmobile.domain.usecase.auth.SignUpUseCase signUpUseCase, @org.jetbrains.annotations.NotNull()
    com.personal.endpointmobile.domain.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.personal.endpointmobile.core.utils.Resource<com.personal.endpointmobile.domain.model.User>> getAuthState() {
        return null;
    }
    
    public final boolean isLoggedIn() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.personal.endpointmobile.domain.model.User getCurrentUser() {
        return null;
    }
    
    public final void signIn(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    public final void signUp(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String displayName) {
    }
    
    public final void signOut() {
    }
    
    public final void resetState() {
    }
}