package com.personal.endpointmobile.data.local.dao

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.personal.endpointmobile.domain.model.Order

class OrderDao(private val db: SQLiteDatabase) {

    companion object {
        const val TABLE_NAME = "orders"
        const val CREATE_TABLE = """
            CREATE TABLE orders (
                id          INTEGER PRIMARY KEY,
                name        TEXT    NOT NULL,
                platform    TEXT    NOT NULL,
                phone       TEXT,
                province    TEXT,
                district    TEXT,
                sub_district TEXT,
                detail      TEXT,
                created_at  INTEGER NOT NULL
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
        }
        db.update(TABLE_NAME, values, "id = ?", arrayOf(order.id.toString()))
    }

    fun getAll(): List<Order> {
        val result = mutableListOf<Order>()
        val cursor = db.query(
            TABLE_NAME,
            null,
            null, null, null, null,
            "id DESC"
        )
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
                        createdAt   = it.getLong(it.getColumnIndexOrThrow("created_at"))
                    )
                )
            }
        }
        return result
    }
}
