package com.personal.endpointmobile.presentation.ui.home;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u0019H\u0082@\u00a2\u0006\u0002\u0010\u001bJ$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0019H\u0016J\u001a\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010\'\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020\u0019H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/personal/endpointmobile/presentation/ui/home/OrderResultFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/personal/endpointmobile/databinding/FragmentOrderResultBinding;", "activeFilter", "Lcom/personal/endpointmobile/domain/model/OrderFilter;", "binding", "getBinding", "()Lcom/personal/endpointmobile/databinding/FragmentOrderResultBinding;", "cardMode", "Lcom/personal/endpointmobile/presentation/ui/home/OrderResultAdapter$Mode;", "filterStore", "Lcom/personal/endpointmobile/core/utils/OrderFilterStore;", "orderRepository", "Lcom/personal/endpointmobile/domain/repository/OrderRepository;", "getOrderRepository", "()Lcom/personal/endpointmobile/domain/repository/OrderRepository;", "setOrderRepository", "(Lcom/personal/endpointmobile/domain/repository/OrderRepository;)V", "timeoutHandler", "Landroid/os/Handler;", "timeoutRunnable", "Ljava/lang/Runnable;", "hideSpinner", "", "loadOrders", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "showSpinnerWithTimeout", "updateFilterButton", "app_debug"})
public final class OrderResultFragment extends androidx.fragment.app.Fragment {
    @javax.inject.Inject()
    public com.personal.endpointmobile.domain.repository.OrderRepository orderRepository;
    @org.jetbrains.annotations.Nullable()
    private com.personal.endpointmobile.databinding.FragmentOrderResultBinding _binding;
    private com.personal.endpointmobile.core.utils.OrderFilterStore filterStore;
    @org.jetbrains.annotations.NotNull()
    private com.personal.endpointmobile.domain.model.OrderFilter activeFilter;
    @org.jetbrains.annotations.NotNull()
    private com.personal.endpointmobile.presentation.ui.home.OrderResultAdapter.Mode cardMode = com.personal.endpointmobile.presentation.ui.home.OrderResultAdapter.Mode.DELETE;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler timeoutHandler = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Runnable timeoutRunnable = null;
    
    public OrderResultFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personal.endpointmobile.domain.repository.OrderRepository getOrderRepository() {
        return null;
    }
    
    public final void setOrderRepository(@org.jetbrains.annotations.NotNull()
    com.personal.endpointmobile.domain.repository.OrderRepository p0) {
    }
    
    private final com.personal.endpointmobile.databinding.FragmentOrderResultBinding getBinding() {
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
    
    private final void updateFilterButton() {
    }
    
    private final java.lang.Object loadOrders(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}