package com.personal.endpointmobile.presentation.ui.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u001a\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/personal/endpointmobile/presentation/ui/home/EditOrderDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "_binding", "Lcom/personal/endpointmobile/databinding/DialogEditOrderBinding;", "binding", "getBinding", "()Lcom/personal/endpointmobile/databinding/DialogEditOrderBinding;", "onConfirm", "Lkotlin/Function1;", "Lcom/personal/endpointmobile/domain/model/Order;", "", "order", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "prefillFields", "Companion", "app_debug"})
public final class EditOrderDialog extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
    @org.jetbrains.annotations.Nullable()
    private com.personal.endpointmobile.databinding.DialogEditOrderBinding _binding;
    private com.personal.endpointmobile.domain.model.Order order;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super com.personal.endpointmobile.domain.model.Order, kotlin.Unit> onConfirm;
    @org.jetbrains.annotations.NotNull()
    public static final com.personal.endpointmobile.presentation.ui.home.EditOrderDialog.Companion Companion = null;
    
    public EditOrderDialog() {
        super();
    }
    
    private final com.personal.endpointmobile.databinding.DialogEditOrderBinding getBinding() {
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
    
    private final void prefillFields() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b\u00a8\u0006\n"}, d2 = {"Lcom/personal/endpointmobile/presentation/ui/home/EditOrderDialog$Companion;", "", "()V", "newInstance", "Lcom/personal/endpointmobile/presentation/ui/home/EditOrderDialog;", "order", "Lcom/personal/endpointmobile/domain/model/Order;", "onConfirm", "Lkotlin/Function1;", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.personal.endpointmobile.presentation.ui.home.EditOrderDialog newInstance(@org.jetbrains.annotations.NotNull()
        com.personal.endpointmobile.domain.model.Order order, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.personal.endpointmobile.domain.model.Order, kotlin.Unit> onConfirm) {
            return null;
        }
    }
}