package com.personal.endpointmobile.presentation.ui.home;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u001a\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\u000e\u0010 \u001a\u00020\u0013H\u0082@\u00a2\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0013H\u0002J\b\u0010#\u001a\u00020$H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/personal/endpointmobile/presentation/ui/home/OrdersFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/personal/endpointmobile/databinding/FragmentOrdersBinding;", "binding", "getBinding", "()Lcom/personal/endpointmobile/databinding/FragmentOrdersBinding;", "orderRepository", "Lcom/personal/endpointmobile/domain/repository/OrderRepository;", "getOrderRepository", "()Lcom/personal/endpointmobile/domain/repository/OrderRepository;", "setOrderRepository", "(Lcom/personal/endpointmobile/domain/repository/OrderRepository;)V", "timeoutHandler", "Landroid/os/Handler;", "timeoutRunnable", "Ljava/lang/Runnable;", "hideSpinner", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "resetFields", "saveOrder", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showSpinnerWithTimeout", "validateForm", "", "app_debug"})
public final class OrdersFragment extends androidx.fragment.app.Fragment {
    @javax.inject.Inject()
    public com.personal.endpointmobile.domain.repository.OrderRepository orderRepository;
    @org.jetbrains.annotations.Nullable()
    private com.personal.endpointmobile.databinding.FragmentOrdersBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler timeoutHandler = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Runnable timeoutRunnable = null;
    
    public OrdersFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personal.endpointmobile.domain.repository.OrderRepository getOrderRepository() {
        return null;
    }
    
    public final void setOrderRepository(@org.jetbrains.annotations.NotNull()
    com.personal.endpointmobile.domain.repository.OrderRepository p0) {
    }
    
    private final com.personal.endpointmobile.databinding.FragmentOrdersBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showSpinnerWithTimeout() {
    }
    
    private final void hideSpinner() {
    }
    
    private final java.lang.Object saveOrder(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final boolean validateForm() {
        return false;
    }
    
    private final void resetFields() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}