package com.personal.endpointmobile.domain.model

data class OrderFilter(
    val name: String = "",
    val platform: String = "",
    val province: String = "",
    val district: String = "",
    val subDistrict: String = "",
    val status: String = "",
    val receivedAt: Long = 0L
) {
    val isEmpty: Boolean
        get() = name.isEmpty() && platform.isEmpty() && province.isEmpty() &&
                district.isEmpty() && subDistrict.isEmpty() && status.isEmpty() && receivedAt == 0L
}
