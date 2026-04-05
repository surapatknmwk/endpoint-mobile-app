package com.personal.endpointmobile.core.utils

import android.content.Context
import com.personal.endpointmobile.domain.model.OrderFilter

class OrderFilterStore(context: Context) {

    private val prefs = context.getSharedPreferences("order_filter_draft", Context.MODE_PRIVATE)

    fun save(filter: OrderFilter) {
        prefs.edit().apply {
            putString("name", filter.name)
            putString("platform", filter.platform)
            putString("province", filter.province)
            putString("district", filter.district)
            putString("subDistrict", filter.subDistrict)
            putString("status", filter.status)
            putLong("receivedAt", filter.receivedAt)
            apply()
        }
    }

    fun load(): OrderFilter = OrderFilter(
        name        = prefs.getString("name", "") ?: "",
        platform    = prefs.getString("platform", "") ?: "",
        province    = prefs.getString("province", "") ?: "",
        district    = prefs.getString("district", "") ?: "",
        subDistrict = prefs.getString("subDistrict", "") ?: "",
        status      = prefs.getString("status", "") ?: "",
        receivedAt  = prefs.getLong("receivedAt", 0L)
    )

    fun clear() {
        prefs.edit().clear().apply()
    }
}
