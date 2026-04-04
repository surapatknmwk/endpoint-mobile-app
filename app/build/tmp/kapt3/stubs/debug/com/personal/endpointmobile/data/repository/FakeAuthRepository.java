package com.personal.endpointmobile.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\rH\u0016J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0013J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u0010H\u0096@\u00a2\u0006\u0002\u0010\u0018J,\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u001bR\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u001c"}, d2 = {"Lcom/personal/endpointmobile/data/repository/FakeAuthRepository;", "Lcom/personal/endpointmobile/domain/repository/AuthRepository;", "()V", "authState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/personal/endpointmobile/domain/model/User;", "currentUser", "getCurrentUser", "()Lcom/personal/endpointmobile/domain/model/User;", "isLoggedIn", "", "()Z", "observeAuthState", "Lkotlinx/coroutines/flow/Flow;", "resetPassword", "Lcom/personal/endpointmobile/core/utils/Resource;", "", "email", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signIn", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signOut", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signUp", "displayName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class FakeAuthRepository implements com.personal.endpointmobile.domain.repository.AuthRepository {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.personal.endpointmobile.domain.model.User> authState = null;
    
    @javax.inject.Inject()
    public FakeAuthRepository() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public com.personal.endpointmobile.domain.model.User getCurrentUser() {
        return null;
    }
    
    @java.lang.Override()
    public boolean isLoggedIn() {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object signIn(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personal.endpointmobile.core.utils.Resource<com.personal.endpointmobile.domain.model.User>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object signUp(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String displayName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personal.endpointmobile.core.utils.Resource<com.personal.endpointmobile.domain.model.User>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object signOut(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object resetPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personal.endpointmobile.core.utils.Resource<kotlin.Unit>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.personal.endpointmobile.domain.model.User> observeAuthState() {
        return null;
    }
}