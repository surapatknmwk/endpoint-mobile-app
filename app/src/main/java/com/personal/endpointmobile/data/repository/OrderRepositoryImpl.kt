package com.personal.endpointmobile.data.repository

import com.personal.endpointmobile.data.local.dao.OrderDao
import com.personal.endpointmobile.data.local.db.AppDatabase
import com.personal.endpointmobile.domain.model.Order
import com.personal.endpointmobile.domain.model.OrderFilter
import com.personal.endpointmobile.domain.repository.OrderRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val database: AppDatabase
) : OrderRepository {

    override suspend fun insert(order: Order): Long = withContext(Dispatchers.IO) {
        OrderDao(database.writableDatabase).insert(order)
    }

    override suspend fun getAll(): List<Order> = withContext(Dispatchers.IO) {
        OrderDao(database.readableDatabase).getAll()
    }

    override suspend fun filter(filter: OrderFilter): List<Order> = withContext(Dispatchers.IO) {
        OrderDao(database.readableDatabase).filter(filter)
    }

    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        OrderDao(database.writableDatabase).deleteById(id)
    }

    override suspend fun updateById(order: Order) = withContext(Dispatchers.IO) {
        OrderDao(database.writableDatabase).updateById(order)
    }
}
