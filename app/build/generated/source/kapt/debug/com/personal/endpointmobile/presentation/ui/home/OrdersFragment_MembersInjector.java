package com.personal.endpointmobile.presentation.ui.home;

import com.personal.endpointmobile.domain.repository.OrderRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class OrdersFragment_MembersInjector implements MembersInjector<OrdersFragment> {
  private final Provider<OrderRepository> orderRepositoryProvider;

  public OrdersFragment_MembersInjector(Provider<OrderRepository> orderRepositoryProvider) {
    this.orderRepositoryProvider = orderRepositoryProvider;
  }

  public static MembersInjector<OrdersFragment> create(
      Provider<OrderRepository> orderRepositoryProvider) {
    return new OrdersFragment_MembersInjector(orderRepositoryProvider);
  }

  @Override
  public void injectMembers(OrdersFragment instance) {
    injectOrderRepository(instance, orderRepositoryProvider.get());
  }

  @InjectedFieldSignature("com.personal.endpointmobile.presentation.ui.home.OrdersFragment.orderRepository")
  public static void injectOrderRepository(OrdersFragment instance,
      OrderRepository orderRepository) {
    instance.orderRepository = orderRepository;
  }
}
