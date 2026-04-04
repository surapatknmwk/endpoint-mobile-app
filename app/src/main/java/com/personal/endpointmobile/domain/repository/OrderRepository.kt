package com.personal.endpointmobile.domain.repository

import com.personal.endpointmobile.domain.model.Order

interface OrderRepository {
    suspend fun insert(order: Order): Long
    suspend fun getAll(): List<Order>
    suspend fun deleteById(id: Long)
    suspend fun updateById(order: Order)
}
