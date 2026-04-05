package com.personal.endpointmobile.presentation.ui.home

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import androidx.fragment.app.DialogFragment
import com.personal.endpointmobile.R
import com.personal.endpointmobile.core.utils.setupLocationDropdowns
import com.personal.endpointmobile.core.utils.setupPlatformDropdown
import com.personal.endpointmobile.databinding.DialogAddOrderBinding
import com.personal.endpointmobile.domain.model.Order

class AddOrderDialog : DialogFragment() {

    private var _binding: DialogAddOrderBinding? = null
    private val binding get() = _binding!!

    private var onConfirm: ((Order) -> Unit)? = null

    companion object {
        fun newInstance(onConfirm: (Order) -> Unit): AddOrderDialog {
            return AddOrderDialog().apply {
                this.onConfirm = onConfirm
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.TopSheetDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = DialogAddOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPlatformDropdown(binding.tilPlatform)
        setupLocationDropdowns(binding.tilProvince, binding.tilDistrict, binding.tilSubDistrict)

        binding.btnCancel.setOnClickListener { dismiss() }

        binding.btnAddOrder.setOnClickListener {
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

            val order = Order(
                name        = name,
                platform    = platform,
                phone       = binding.etPhone.text?.toString()?.trim() ?: "",
                province    = (binding.tilProvince.editText as AutoCompleteTextView).text.toString().trim(),
                district    = (binding.tilDistrict.editText as AutoCompleteTextView).text.toString().trim(),
                subDistrict = (binding.tilSubDistrict.editText as AutoCompleteTextView).text.toString().trim(),
                detail      = binding.etDetail.text?.toString()?.trim() ?: "",
                status      = "ใหม่",
                receivedAt  = System.currentTimeMillis()
            )
            onConfirm?.invoke(order)
            dismiss()
        }
    }

    override fun onStart() {
        dialog?.window?.apply {
            setWindowAnimations(R.style.TopSheetAnimation)
            val params = attributes
            params.gravity = Gravity.TOP
            params.width = ViewGroup.LayoutParams.MATCH_PARENT
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT
            attributes = params
        }
        super.onStart()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
