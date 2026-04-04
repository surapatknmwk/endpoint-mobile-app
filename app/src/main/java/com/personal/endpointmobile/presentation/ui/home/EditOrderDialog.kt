package com.personal.endpointmobile.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.personal.endpointmobile.core.data.LocationMasterData
import com.personal.endpointmobile.core.utils.setupLocationDropdowns
import com.personal.endpointmobile.core.utils.setupPlatformDropdown
import com.personal.endpointmobile.databinding.DialogEditOrderBinding
import com.personal.endpointmobile.domain.model.Order

class EditOrderDialog : BottomSheetDialogFragment() {

    private var _binding: DialogEditOrderBinding? = null
    private val binding get() = _binding!!

    private lateinit var order: Order
    private var onConfirm: ((Order) -> Unit)? = null

    companion object {
        fun newInstance(order: Order, onConfirm: (Order) -> Unit): EditOrderDialog {
            return EditOrderDialog().apply {
                this.order = order
                this.onConfirm = onConfirm
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = DialogEditOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPlatformDropdown(binding.tilPlatform)
        setupLocationDropdowns(binding.tilProvince, binding.tilDistrict, binding.tilSubDistrict)

        prefillFields()

        binding.btnCancel.setOnClickListener { dismiss() }

        binding.btnConfirm.setOnClickListener {
            val name = binding.etName.text?.toString()?.trim() ?: ""
            val platform = (binding.tilPlatform.editText as AutoCompleteTextView).text.toString().trim()

            var hasError = false
            if (name.isEmpty()) {
                binding.tilName.error = "กรุณากรอกชื่อ"
                hasError = true
            } else {
                binding.tilName.error = null
            }
            if (platform.isEmpty()) {
                binding.tilPlatform.error = "กรุณาเลือก Platform"
                hasError = true
            } else {
                binding.tilPlatform.error = null
            }
            if (hasError) return@setOnClickListener

            val updated = order.copy(
                name        = name,
                platform    = platform,
                phone       = binding.etPhone.text?.toString()?.trim() ?: "",
                province    = (binding.tilProvince.editText as AutoCompleteTextView).text.toString().trim(),
                district    = (binding.tilDistrict.editText as AutoCompleteTextView).text.toString().trim(),
                subDistrict = (binding.tilSubDistrict.editText as AutoCompleteTextView).text.toString().trim(),
                detail      = binding.etDetail.text?.toString()?.trim() ?: ""
            )
            onConfirm?.invoke(updated)
            dismiss()
        }
    }

    private fun prefillFields() {
        binding.etName.setText(order.name)
        (binding.tilPlatform.editText as AutoCompleteTextView).setText(order.platform, false)
        binding.etPhone.setText(order.phone)
        binding.etDetail.setText(order.detail)

        if (order.province.isNotEmpty()) {
            val actvProvince    = binding.tilProvince.editText as AutoCompleteTextView
            val actvDistrict    = binding.tilDistrict.editText as AutoCompleteTextView
            val actvSubDistrict = binding.tilSubDistrict.editText as AutoCompleteTextView

            val province = LocationMasterData.provinces.find { it.name == order.province }
            if (province != null) {
                actvProvince.setText(province.name, false)
                actvDistrict.setAdapter(
                    ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line,
                        province.districts.map { it.name })
                )
                binding.tilDistrict.isEnabled = true

                val district = province.districts.find { it.name == order.district }
                if (district != null) {
                    actvDistrict.setText(district.name, false)
                    actvSubDistrict.setAdapter(
                        ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line,
                            district.subDistricts.map { it.name })
                    )
                    binding.tilSubDistrict.isEnabled = true
                    actvSubDistrict.setText(order.subDistrict, false)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
