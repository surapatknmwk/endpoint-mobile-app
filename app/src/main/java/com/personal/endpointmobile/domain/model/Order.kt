package com.personal.endpointmobile.domain.model

data class Order(
    val id: Long = System.currentTimeMillis(),
    val name: String,
    val platform: String,
    val phone: String,
    val province: String,
    val district: String,
    val subDistrict: String,
    val detail: String,
    val createdAt: Long = System.currentTimeMillis()
)
