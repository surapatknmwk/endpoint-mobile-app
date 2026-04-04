package com.personal.endpointmobile.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/personal/endpointmobile/domain/repository/OrderRepository;", "", "deleteById", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "", "Lcom/personal/endpointmobile/domain/model/Order;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "order", "(Lcom/personal/endpointmobile/domain/model/Order;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateById", "app_debug"})
public abstract interface OrderRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.personal.endpointmobile.domain.model.Order order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.personal.endpointmobile.domain.model.Order>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateById(@org.jetbrains.annotations.NotNull()
    com.personal.endpointmobile.domain.model.Order order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}