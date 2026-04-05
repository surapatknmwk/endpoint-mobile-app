package com.personal.endpointmobile.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000bJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014H\u0002\u00a2\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/personal/endpointmobile/data/local/dao/OrderDao;", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "(Landroid/database/sqlite/SQLiteDatabase;)V", "deleteById", "", "id", "", "filter", "", "Lcom/personal/endpointmobile/domain/model/Order;", "Lcom/personal/endpointmobile/domain/model/OrderFilter;", "getAll", "insert", "order", "query", "selection", "", "selectionArgs", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;", "updateById", "Companion", "app_debug"})
public final class OrderDao {
    @org.jetbrains.annotations.NotNull()
    private final android.database.sqlite.SQLiteDatabase db = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TABLE_NAME = "orders";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CREATE_TABLE = "\n            CREATE TABLE orders (\n                id           INTEGER PRIMARY KEY,\n                name         TEXT    NOT NULL,\n                platform     TEXT    NOT NULL,\n                phone        TEXT,\n                province     TEXT,\n                district     TEXT,\n                sub_district TEXT,\n                detail       TEXT,\n                status       TEXT    NOT NULL DEFAULT \'\u0e43\u0e2b\u0e21\u0e48\',\n                received_at  INTEGER NOT NULL DEFAULT 0,\n                created_at   INTEGER NOT NULL\n            )\n        ";
    @org.jetbrains.annotations.NotNull()
    public static final com.personal.endpointmobile.data.local.dao.OrderDao.Companion Companion = null;
    
    public OrderDao(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase db) {
        super();
    }
    
    public final long insert(@org.jetbrains.annotations.NotNull()
    com.personal.endpointmobile.domain.model.Order order) {
        return 0L;
    }
    
    public final void deleteById(long id) {
    }
    
    public final void updateById(@org.jetbrains.annotations.NotNull()
    com.personal.endpointmobile.domain.model.Order order) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.personal.endpointmobile.domain.model.Order> getAll() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.personal.endpointmobile.domain.model.Order> filter(@org.jetbrains.annotations.NotNull()
    com.personal.endpointmobile.domain.model.OrderFilter filter) {
        return null;
    }
    
    private final java.util.List<com.personal.endpointmobile.domain.model.Order> query(java.lang.String selection, java.lang.String[] selectionArgs) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/personal/endpointmobile/data/local/dao/OrderDao$Companion;", "", "()V", "CREATE_TABLE", "", "TABLE_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}