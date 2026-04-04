package com.personal.endpointmobile.presentation.ui.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B;\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/personal/endpointmobile/presentation/ui/home/OrderResultAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/personal/endpointmobile/presentation/ui/home/OrderResultAdapter$ViewHolder;", "orders", "", "Lcom/personal/endpointmobile/domain/model/Order;", "onCardClick", "Lkotlin/Function1;", "", "onDeleteClick", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class OrderResultAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.personal.endpointmobile.presentation.ui.home.OrderResultAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.personal.endpointmobile.domain.model.Order> orders = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.personal.endpointmobile.domain.model.Order, kotlin.Unit> onCardClick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.personal.endpointmobile.domain.model.Order, kotlin.Unit> onDeleteClick = null;
    
    public OrderResultAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.personal.endpointmobile.domain.model.Order> orders, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.personal.endpointmobile.domain.model.Order, kotlin.Unit> onCardClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.personal.endpointmobile.domain.model.Order, kotlin.Unit> onDeleteClick) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.personal.endpointmobile.presentation.ui.home.OrderResultAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.personal.endpointmobile.presentation.ui.home.OrderResultAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/personal/endpointmobile/presentation/ui/home/OrderResultAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "btnDeleteItem", "Lcom/google/android/material/button/MaterialButton;", "getBtnDeleteItem", "()Lcom/google/android/material/button/MaterialButton;", "tvAddress", "Landroid/widget/TextView;", "getTvAddress", "()Landroid/widget/TextView;", "tvDetail", "getTvDetail", "tvName", "getTvName", "tvPhone", "getTvPhone", "tvPlatform", "getTvPlatform", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvPlatform = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvPhone = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvAddress = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvDetail = null;
        @org.jetbrains.annotations.NotNull()
        private final com.google.android.material.button.MaterialButton btnDeleteItem = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvPlatform() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvPhone() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvAddress() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvDetail() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.google.android.material.button.MaterialButton getBtnDeleteItem() {
            return null;
        }
    }
}