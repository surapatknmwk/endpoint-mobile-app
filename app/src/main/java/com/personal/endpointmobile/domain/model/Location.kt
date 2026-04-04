package com.personal.endpointmobile.domain.model

data class Province(
    val id: Int,
    val name: String,
    val districts: List<District>
)

data class District(
    val id: Int,
    val name: String,
    val subDistricts: List<SubDistrict>
)

data class SubDistrict(
    val id: Int,
    val name: String,
    val zipCode: String
)
