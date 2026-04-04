package com.personal.endpointmobile.core.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002Jl\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/personal/endpointmobile/core/utils/AppDialog;", "", "()V", "show", "", "fragment", "Landroidx/fragment/app/Fragment;", "type", "Lcom/personal/endpointmobile/core/utils/AppDialog$Type;", "title", "", "message", "positiveText", "negativeText", "cancelable", "", "onPositive", "Lkotlin/Function0;", "onNegative", "Type", "app_debug"})
public final class AppDialog {
    @org.jetbrains.annotations.NotNull()
    public static final com.personal.endpointmobile.core.utils.AppDialog INSTANCE = null;
    
    private AppDialog() {
        super();
    }
    
    public final void show(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.NotNull()
    com.personal.endpointmobile.core.utils.AppDialog.Type type, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.String positiveText, @org.jetbrains.annotations.Nullable()
    java.lang.String negativeText, boolean cancelable, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> onPositive, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNegative) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/personal/endpointmobile/core/utils/AppDialog$Type;", "", "(Ljava/lang/String;I)V", "SUCCESS", "ERROR", "WARNING", "INFO", "app_debug"})
    public static enum Type {
        /*public static final*/ SUCCESS /* = new SUCCESS() */,
        /*public static final*/ ERROR /* = new ERROR() */,
        /*public static final*/ WARNING /* = new WARNING() */,
        /*public static final*/ INFO /* = new INFO() */;
        
        Type() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.personal.endpointmobile.core.utils.AppDialog.Type> getEntries() {
            return null;
        }
    }
}