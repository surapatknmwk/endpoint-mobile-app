package com.personal.endpointmobile.presentation.ui.home

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.DialogFragment
import com.personal.endpointmobile.R
import com.personal.endpointmobile.core.data.LocationMasterData
import com.personal.endpointmobile.core.utils.setupLocationDropdowns
import com.personal.endpointmobile.core.utils.setupPlatformDropdown
import com.personal.endpointmobile.core.utils.setupStatusDropdown
import com.personal.endpointmobile.databinding.DialogFilterOrderBinding
import com.personal.endpointmobile.domain.model.OrderFilter
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class FilterOrderDialog : DialogFragment() {

    private var _binding: DialogFilterOrderBinding? = null
    private val binding get() = _binding!!

    private var initialFilter: OrderFilter = OrderFilter()
    private var onApply: ((OrderFilter) -> Unit)? = null
    private var onReset: (() -> Unit)? = null
    private var onDraft: ((OrderFilter) -> Unit)? = null

    private var actionHandled = false
    private var selectedReceivedAt: Long = 0L
    private var resetLocation: (() -> Unit)? = null

    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    companion object {
        fun newInstance(
            initialFilter: OrderFilter,
            onApply: (OrderFilter) -> Unit,
            onReset: () -> Unit,
            onDraft: (OrderFilter) -> Unit
        ): FilterOrderDialog {
            return FilterOrderDialog().apply {
                this.initialFilter = initialFilter
                this.onApply = onApply
                this.onReset = onReset
                this.onDraft = onDraft
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.CenterDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = DialogFilterOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPlatformDropdown(binding.tilPlatform)
        resetLocation = setupLocationDropdowns(binding.tilProvince, binding.tilDistrict, binding.tilSubDistrict)
        setupStatusDropdown(binding.tilStatus)

        prefillFields()

        binding.etReceivedAt.setOnClickListener { showDatePicker() }
        binding.tilReceivedAt.setEndIconOnClickListener {
            selectedReceivedAt = 0L
            binding.etReceivedAt.setText("")
            binding.tilReceivedAt.isEndIconVisible = false
        }

        binding.btnApplyFilter.setOnClickListener {
            actionHandled = true
            onApply?.invoke(buildFilter())
            dismiss()
        }

        binding.btnReset.setOnClickListener {
            actionHandled = true
            onReset?.invoke()
            dismiss()
        }
    }

    private fun prefillFields() {
        binding.etName.setText(initialFilter.name)
        (binding.tilPlatform.editText as AutoCompleteTextView).setText(initialFilter.platform, false)
        (binding.tilStatus.editText as AutoCompleteTextView).setText(initialFilter.status, false)

        selectedReceivedAt = initialFilter.receivedAt
        if (selectedReceivedAt != 0L) {
            binding.etReceivedAt.setText(dateFormat.format(selectedReceivedAt))
            binding.tilReceivedAt.isEndIconVisible = true
        } else {
            binding.tilReceivedAt.isEndIconVisible = false
        }

        if (initialFilter.province.isNotEmpty()) {
            val actvProvince    = binding.tilProvince.editText as AutoCompleteTextView
            val actvDistrict    = binding.tilDistrict.editText as AutoCompleteTextView
            val actvSubDistrict = binding.tilSubDistrict.editText as AutoCompleteTextView

            val province = LocationMasterData.provinces.find { it.name == initialFilter.province }
            if (province != null) {
                actvProvince.setText(province.name, false)
                actvDistrict.setAdapter(
                    ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line,
                        province.districts.map { it.name })
                )
                binding.tilDistrict.isEnabled = true

                val district = province.districts.find { it.name == initialFilter.district }
                if (district != null) {
                    actvDistrict.setText(district.name, false)
                    actvSubDistrict.setAdapter(
                        ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line,
                            district.subDistricts.map { it.name })
                    )
                    binding.tilSubDistrict.isEnabled = true
                    actvSubDistrict.setText(initialFilter.subDistrict, false)
                }
            }
        }
    }

    private fun showDatePicker() {
        val cal = Calendar.getInstance()
        if (selectedReceivedAt != 0L) cal.timeInMillis = selectedReceivedAt
        DatePickerDialog(
            requireContext(),
            { _, year, month, day ->
                cal.set(year, month, day, 0, 0, 0)
                cal.set(Calendar.MILLISECOND, 0)
                selectedReceivedAt = cal.timeInMillis
                binding.etReceivedAt.setText(dateFormat.format(cal.time))
                binding.tilReceivedAt.isEndIconVisible = true
            },
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun buildFilter(): OrderFilter = OrderFilter(
        name        = binding.etName.text?.toString()?.trim() ?: "",
        platform    = (binding.tilPlatform.editText as AutoCompleteTextView).text.toString().trim(),
        province    = (binding.tilProvince.editText as AutoCompleteTextView).text.toString().trim(),
        district    = (binding.tilDistrict.editText as AutoCompleteTextView).text.toString().trim(),
        subDistrict = (binding.tilSubDistrict.editText as AutoCompleteTextView).text.toString().trim(),
        status      = (binding.tilStatus.editText as AutoCompleteTextView).text.toString().trim(),
        receivedAt  = selectedReceivedAt
    )

    override fun onStart() {
        super.onStart()
        dialog?.setCanceledOnTouchOutside(true)
        dialog?.window?.apply {
            setBackgroundDrawableResource(R.drawable.bg_dialog_center)
            val screenWidth = resources.displayMetrics.widthPixels
            setLayout((screenWidth * 0.92).toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        actionHandled = true
        super.onCancel(dialog)
    }

    override fun onDestroyView() {
        if (!actionHandled) {
            onDraft?.invoke(buildFilter())
        }
        super.onDestroyView()
        _binding = null
    }
}
