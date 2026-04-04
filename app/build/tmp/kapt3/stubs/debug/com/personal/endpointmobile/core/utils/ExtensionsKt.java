package com.personal.endpointmobile.core.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aG\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u00a2\u0006\u0002\u0010\n\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\f\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\f\u001a\u0012\u0010\u000e\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010\u001a\n\u0010\u0011\u001a\u00020\u0001*\u00020\f\u00a8\u0006\u0012"}, d2 = {"collectFlow", "", "T", "Landroidx/fragment/app/Fragment;", "flow", "Lkotlinx/coroutines/flow/Flow;", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/fragment/app/Fragment;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)V", "gone", "Landroid/view/View;", "invisible", "showToast", "message", "", "visible", "app_debug"})
public final class ExtensionsKt {
    
    public static final void visible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$visible) {
    }
    
    public static final void invisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$invisible) {
    }
    
    public static final void gone(@org.jetbrains.annotations.NotNull()
    android.view.View $this$gone) {
    }
    
    public static final void showToast(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$showToast, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public static final <T extends java.lang.Object>void collectFlow(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$collectFlow, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> action) {
    }
}