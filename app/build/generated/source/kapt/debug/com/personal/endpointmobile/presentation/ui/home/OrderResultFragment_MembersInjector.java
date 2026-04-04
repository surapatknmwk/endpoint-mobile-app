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
public final class OrderResultFragment_MembersInjector implements MembersInjector<OrderResultFragment> {
  private final Provider<OrderRepository> orderRepositoryProvider;

  public OrderResultFragment_MembersInjector(Provider<OrderRepository> orderRepositoryProvider) {
    this.orderRepositoryProvider = orderRepositoryProvider;
  }

  public static MembersInjector<OrderResultFragment> create(
      Provider<OrderRepository> orderRepositoryProvider) {
    return new OrderResultFragment_MembersInjector(orderRepositoryProvider);
  }

  @Override
  public void injectMembers(OrderResultFragment instance) {
    injectOrderRepository(instance, orderRepositoryProvider.get());
  }

  @InjectedFieldSignature("com.personal.endpointmobile.presentation.ui.home.OrderResultFragment.orderRepository")
  public static void injectOrderRepository(OrderResultFragment instance,
      OrderRepository orderRepository) {
    instance.orderRepository = orderRepository;
  }
}
