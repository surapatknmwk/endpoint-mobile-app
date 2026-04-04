package com.personal.endpointmobile.data.repository;

import com.personal.endpointmobile.data.local.db.AppDatabase;
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
public final class OrderRepositoryImpl_Factory implements Factory<OrderRepositoryImpl> {
  private final Provider<AppDatabase> databaseProvider;

  public OrderRepositoryImpl_Factory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public OrderRepositoryImpl get() {
    return newInstance(databaseProvider.get());
  }

  public static OrderRepositoryImpl_Factory create(Provider<AppDatabase> databaseProvider) {
    return new OrderRepositoryImpl_Factory(databaseProvider);
  }

  public static OrderRepositoryImpl newInstance(AppDatabase database) {
    return new OrderRepositoryImpl(database);
  }
}
