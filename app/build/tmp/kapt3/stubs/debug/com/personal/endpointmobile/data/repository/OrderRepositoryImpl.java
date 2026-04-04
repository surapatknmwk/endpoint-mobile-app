package com.personal.endpointmobile.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/personal/endpointmobile/data/repository/OrderRepositoryImpl;", "Lcom/personal/endpointmobile/domain/repository/OrderRepository;", "database", "Lcom/personal/endpointmobile/data/local/db/AppDatabase;", "(Lcom/personal/endpointmobile/data/local/db/AppDatabase;)V", "deleteById", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "", "Lcom/personal/endpointmobile/domain/model/Order;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "order", "(Lcom/personal/endpointmobile/domain/model/Order;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateById", "app_debug"})
public final class OrderRepositoryImpl implements com.personal.endpointmobile.domain.repository.OrderRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.personal.endpointmobile.data.local.db.AppDatabase database = null;
    
    @javax.inject.Inject()
    public OrderRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.personal.endpointmobile.data.local.db.AppDatabase database) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.personal.endpointmobile.domain.model.Order order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.personal.endpointmobile.domain.model.Order>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateById(@org.jetbrains.annotations.NotNull()
    com.personal.endpointmobile.domain.model.Order order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}