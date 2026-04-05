package com.personal.endpointmobile.data.local.dao

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.personal.endpointmobile.domain.model.Order
import com.personal.endpointmobile.domain.model.OrderFilter
import java.util.Calendar

class OrderDao(private val db: SQLiteDatabase) {

    companion object {
        const val TABLE_NAME = "orders"
        const val CREATE_TABLE = """
            CREATE TABLE orders (
                id           INTEGER PRIMARY KEY,
                name         TEXT    NOT NULL,
                platform     TEXT    NOT NULL,
                phone        TEXT,
                province     TEXT,
                district     TEXT,
                sub_district TEXT,
                detail       TEXT,
                status       TEXT    NOT NULL DEFAULT 'ใหม่',
                received_at  INTEGER NOT NULL DEFAULT 0,
                created_at   INTEGER NOT NULL
            )
        """
    }

    fun insert(order: Order): Long {
        val values = ContentValues().apply {
            put("id",           order.id)
            put("name",         order.name)
            put("platform",     order.platform)
            put("phone",        order.phone)
            put("province",     order.province)
            put("district",     order.district)
            put("sub_district", order.subDistrict)
            put("detail",       order.detail)
            put("status",       order.status)
            put("received_at",  order.receivedAt)
            put("created_at",   order.createdAt)
        }
        return db.insertOrThrow(TABLE_NAME, null, values)
    }

    fun deleteById(id: Long) {
        db.delete(TABLE_NAME, "id = ?", arrayOf(id.toString()))
    }

    fun updateById(order: Order) {
        val values = ContentValues().apply {
            put("name",         order.name)
            put("platform",     order.platform)
            put("phone",        order.phone)
            put("province",     order.province)
            put("district",     order.district)
            put("sub_district", order.subDistrict)
            put("detail",       order.detail)
            put("status",       order.status)
            put("received_at",  order.receivedAt)
        }
        db.update(TABLE_NAME, values, "id = ?", arrayOf(order.id.toString()))
    }

    fun getAll(): List<Order> = query(null, null)

    fun filter(filter: OrderFilter): List<Order> {
        val conditions = mutableListOf<String>()
        val args = mutableListOf<String>()

        if (filter.name.isNotEmpty()) {
            conditions.add("name LIKE ?")
            args.add("%${filter.name}%")
        }
        if (filter.platform.isNotEmpty()) {
            conditions.add("platform = ?")
            args.add(filter.platform)
        }
        if (filter.province.isNotEmpty()) {
            conditions.add("province = ?")
            args.add(filter.province)
        }
        if (filter.district.isNotEmpty()) {
            conditions.add("district = ?")
            args.add(filter.district)
        }
        if (filter.subDistrict.isNotEmpty()) {
            conditions.add("sub_district = ?")
            args.add(filter.subDistrict)
        }
        if (filter.status.isNotEmpty()) {
            conditions.add("status = ?")
            args.add(filter.status)
        }
        if (filter.receivedAt != 0L) {
            val cal = Calendar.getInstance().apply { timeInMillis = filter.receivedAt }
            cal.set(Calendar.HOUR_OF_DAY, 0); cal.set(Calendar.MINUTE, 0)
            cal.set(Calendar.SECOND, 0);      cal.set(Calendar.MILLISECOND, 0)
            val startOfDay = cal.timeInMillis
            cal.set(Calendar.HOUR_OF_DAY, 23); cal.set(Calendar.MINUTE, 59)
            cal.set(Calendar.SECOND, 59);       cal.set(Calendar.MILLISECOND, 999)
            val endOfDay = cal.timeInMillis
            conditions.add("received_at >= ?")
            args.add(startOfDay.toString())
            conditions.add("received_at <= ?")
            args.add(endOfDay.toString())
        }

        val selection = if (conditions.isEmpty()) null else conditions.joinToString(" AND ")
        val selectionArgs = if (args.isEmpty()) null else args.toTypedArray()
        return query(selection, selectionArgs)
    }

    private fun query(selection: String?, selectionArgs: Array<String>?): List<Order> {
        val result = mutableListOf<Order>()
        val cursor = db.query(TABLE_NAME, null, selection, selectionArgs, null, null, "id DESC")
        cursor.use {
            while (it.moveToNext()) {
                result.add(
                    Order(
                        id          = it.getLong(it.getColumnIndexOrThrow("id")),
                        name        = it.getString(it.getColumnIndexOrThrow("name")),
                        platform    = it.getString(it.getColumnIndexOrThrow("platform")),
                        phone       = it.getString(it.getColumnIndexOrThrow("phone")) ?: "",
                        province    = it.getString(it.getColumnIndexOrThrow("province")) ?: "",
                        district    = it.getString(it.getColumnIndexOrThrow("district")) ?: "",
                        subDistrict = it.getString(it.getColumnIndexOrThrow("sub_district")) ?: "",
                        detail      = it.getString(it.getColumnIndexOrThrow("detail")) ?: "",
                        status      = it.getString(it.getColumnIndexOrThrow("status")) ?: "ใหม่",
                        receivedAt  = it.getLong(it.getColumnIndexOrThrow("received_at")),
                        createdAt   = it.getLong(it.getColumnIndexOrThrow("created_at"))
                    )
                )
            }
        }
        return result
    }
}
