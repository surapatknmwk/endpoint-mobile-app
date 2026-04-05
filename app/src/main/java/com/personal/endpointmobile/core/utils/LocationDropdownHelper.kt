package com.personal.endpointmobile.core.utils

import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.personal.endpointmobile.core.data.LocationMasterData
import com.personal.endpointmobile.core.data.PlatformMasterData
import com.personal.endpointmobile.core.data.StatusMasterData
import com.personal.endpointmobile.domain.model.Province

/**
 * ตั้งค่า cascade dropdown จังหวัด → อำเภอ → ตำบล
 *
 * ใช้งาน:
 *   val resetLocation = setupLocationDropdowns(binding.tilProvince, binding.tilDistrict, binding.tilSubDistrict)
 *   resetLocation() // เรียกเพื่อ reset ค่าทั้งหมด
 *
 * @return lambda สำหรับ reset ค่าทั้งหมดกลับสู่สถานะเริ่มต้น
 */
fun Fragment.setupLocationDropdowns(
    tilProvince: TextInputLayout,
    tilDistrict: TextInputLayout,
    tilSubDistrict: TextInputLayout,
): () -> Unit {
    val actvProvince = tilProvince.editText as AutoCompleteTextView
    val actvDistrict = tilDistrict.editText as AutoCompleteTextView
    val actvSubDistrict = tilSubDistrict.editText as AutoCompleteTextView

    var selectedProvince: Province? = null

    // ล็อก district/subDistrict จนกว่าจะเลือก parent
    tilDistrict.isEnabled = false
    tilSubDistrict.isEnabled = false

    // Province — โหลดครั้งเดียวจาก object ใน RAM
    actvProvince.setAdapter(
        ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            LocationMasterData.provinces.map { it.name },
        )
    )

    actvProvince.setOnItemClickListener { _, _, position, _ ->
        selectedProvince = LocationMasterData.provinces[position]

        // reset downstream
        actvDistrict.text.clear()
        actvSubDistrict.text.clear()
        tilSubDistrict.isEnabled = false

        actvDistrict.setAdapter(
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                selectedProvince!!.districts.map { it.name },
            )
        )
        tilDistrict.isEnabled = true
    }

    actvDistrict.setOnItemClickListener { _, _, position, _ ->
        val province = selectedProvince ?: return@setOnItemClickListener
        val district = province.districts[position]

        actvSubDistrict.text.clear()

        actvSubDistrict.setAdapter(
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                district.subDistricts.map { it.name },
            )
        )
        tilSubDistrict.isEnabled = true
    }

    // reset lambda — ส่งกลับให้ caller ใช้เอง
    return {
        selectedProvince = null
        actvProvince.text.clear()
        actvDistrict.text.clear()
        actvSubDistrict.text.clear()
        tilDistrict.isEnabled = false
        tilSubDistrict.isEnabled = false
    }
}

/**
 * ตั้งค่า dropdown สำหรับ Platform (Facebook / Line / TikTok)
 *
 * ใช้งาน:
 *   setupPlatformDropdown(binding.tilPlatform)
 */
fun Fragment.setupPlatformDropdown(tilPlatform: TextInputLayout) {
    val actv = tilPlatform.editText as AutoCompleteTextView
    actv.setAdapter(
        ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            PlatformMasterData.platforms,
        )
    )
}

fun Fragment.setupStatusDropdown(tilStatus: TextInputLayout) {
    val actv = tilStatus.editText as AutoCompleteTextView
    actv.setAdapter(
        ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            StatusMasterData.statuses,
        )
    )
}
