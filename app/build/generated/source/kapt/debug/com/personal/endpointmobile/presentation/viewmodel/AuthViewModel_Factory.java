package com.personal.endpointmobile.presentation.viewmodel;

import com.personal.endpointmobile.domain.repository.AuthRepository;
import com.personal.endpointmobile.domain.usecase.auth.SignInUseCase;
import com.personal.endpointmobile.domain.usecase.auth.SignUpUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class AuthViewModel_Factory implements Factory<AuthViewModel> {
  private final Provider<SignInUseCase> signInUseCaseProvider;

  private final Provider<SignUpUseCase> signUpUseCaseProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  public AuthViewModel_Factory(Provider<SignInUseCase> signInUseCaseProvider,
      Provider<SignUpUseCase> signUpUseCaseProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    this.signInUseCaseProvider = signInUseCaseProvider;
    this.signUpUseCaseProvider = signUpUseCaseProvider;
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public AuthViewModel get() {
    return newInstance(signInUseCaseProvider.get(), signUpUseCaseProvider.get(), authRepositoryProvider.get());
  }

  public static AuthViewModel_Factory create(Provider<SignInUseCase> signInUseCaseProvider,
      Provider<SignUpUseCase> signUpUseCaseProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    return new AuthViewModel_Factory(signInUseCaseProvider, signUpUseCaseProvider, authRepositoryProvider);
  }

  public static AuthViewModel newInstance(SignInUseCase signInUseCase, SignUpUseCase signUpUseCase,
      AuthRepository authRepository) {
    return new AuthViewModel(signInUseCase, signUpUseCase, authRepository);
  }
}
