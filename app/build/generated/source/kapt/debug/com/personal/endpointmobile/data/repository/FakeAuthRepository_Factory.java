package com.personal.endpointmobile.data.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class FakeAuthRepository_Factory implements Factory<FakeAuthRepository> {
  @Override
  public FakeAuthRepository get() {
    return newInstance();
  }

  public static FakeAuthRepository_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FakeAuthRepository newInstance() {
    return new FakeAuthRepository();
  }

  private static final class InstanceHolder {
    private static final FakeAuthRepository_Factory INSTANCE = new FakeAuthRepository_Factory();
  }
}
