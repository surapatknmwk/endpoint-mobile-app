package com.personal.endpointmobile.core.sync;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0010"}, d2 = {"Lcom/personal/endpointmobile/core/sync/SheetSyncService;", "", "()V", "SECRET_TOKEN", "", "WEB_APP_URL", "client", "Lokhttp3/OkHttpClient;", "sync", "Lkotlin/Result;", "", "orders", "", "Lcom/personal/endpointmobile/domain/model/Order;", "sync-gIAlu-s", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SheetSyncService {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String WEB_APP_URL = "https://script.google.com/macros/s/AKfycbyUxdWnEt4-cTOz2DwdxpNftmQrYe5K0FR7Mo12QNNpuRygvzbxG-sMTzReSoa7jCNQeQ/exec";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String SECRET_TOKEN = "admin1234";
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.OkHttpClient client = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.personal.endpointmobile.core.sync.SheetSyncService INSTANCE = null;
    
    private SheetSyncService() {
        super();
    }
}