package com.personal.endpointmobile.presentation.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.personal.endpointmobile.R
import com.personal.endpointmobile.core.utils.AppDialog
import com.personal.endpointmobile.core.utils.gone
import com.personal.endpointmobile.core.utils.setupLocationDropdowns
import com.personal.endpointmobile.core.utils.setupPlatformDropdown
import com.personal.endpointmobile.core.utils.visible
import com.personal.endpointmobile.databinding.FragmentOrdersBinding
import com.personal.endpointmobile.domain.model.Order
import com.personal.endpointmobile.domain.repository.OrderRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class OrdersFragment : Fragment() {

    @Inject lateinit var orderRepository: OrderRepository

    private var _binding: FragmentOrdersBinding? = null
    private val binding get() = _binding!!

    private val timeoutHandler = Handler(Looper.getMainLooper())
    private val timeoutRunnable = Runnable {
        if (_binding != null) {
            Toast.makeText(requireContext(), "Error: session timeout", Toast.LENGTH_LONG).show()
            hideSpinner()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrdersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.topBar.tvTitle.text = "Orders"
        binding.topBar.btnBack.gone()

        binding.bottomNav.btnOrders.setOnClickListener {
            findNavController().navigate(R.id.action_ordersFragment_to_orderResultFragment)
        }

        binding.bottomNav.btnMenu.setOnClickListener { }

        setupPlatformDropdown(binding.tilPlatform)
        setupLocationDropdowns(
            binding.tilProvince,
            binding.tilDistrict,
            binding.tilSubDistrict,
        )

        binding.btnAddOrder.setOnClickListener {
            if (validateForm()) {
                showSpinnerWithTimeout()
                lifecycleScope.launch {
                    saveOrder()
                    hideSpinner()
                }
            }
        }

        binding.btnCancel.setOnClickListener {
            showSpinnerWithTimeout()
            resetFields()
            hideSpinner()
        }   
    }

    private fun showSpinnerWithTimeout() {
        binding.viewSpinnerOverlay.visible()
        binding.progressBar.visible()
        timeoutHandler.removeCallbacks(timeoutRunnable)
        timeoutHandler.postDelayed(timeoutRunnable, 3 * 60 * 1000L)
    }

    private fun hideSpinner() {
        timeoutHandler.removeCallbacks(timeoutRunnable)
        timeoutHandler.postDelayed({
            if (_binding != null) {
                binding.progressBar.gone()
                binding.viewSpinnerOverlay.gone()
            }
        }, 700L)
    }

    private suspend fun saveOrder() {
        val order = Order(
            name        = binding.etName.text?.toString().orEmpty().trim(),
            platform    = binding.actvPlatform.text?.toString().orEmpty().trim(),
            phone       = binding.etPhone.text?.toString().orEmpty().trim(),
            province    = binding.actvProvince.text?.toString().orEmpty().trim(),
            district    = binding.actvDistrict.text?.toString().orEmpty().trim(),
            subDistrict = binding.actvSubDistrict.text?.toString().orEmpty().trim(),
            detail      = binding.etDetail.text?.toString().orEmpty().trim()
        )
        orderRepository.insert(order)

        AppDialog.show(
            fragment = this,
            type = AppDialog.Type.SUCCESS,
            title = "สำเร็จ",
            message = "เพิ่ม Order สำเร็จ",
            onPositive = {
                resetFields()
                findNavController().navigate(R.id.action_ordersFragment_to_orderResultFragment)
            }
        )
    }

    private fun validateForm(): Boolean {
        var isValid = true

        val name = binding.etName.text?.toString().orEmpty().trim()
        if (name.isEmpty()) {
            binding.tilName.error = "กรุณากรอกชื่อ"
            isValid = false
        } else {
            binding.tilName.error = null
        }

        val platform = binding.actvPlatform.text?.toString().orEmpty().trim()
        if (platform.isEmpty()) {
            binding.tilPlatform.error = "กรุณาเลือก Platform"
            isValid = false
        } else {
            binding.tilPlatform.error = null
        }

        return isValid
    }

    private fun resetFields() {
        binding.etName.text?.clear()
        binding.actvPlatform.text?.clear()
        binding.etPhone.text?.clear()
        binding.actvProvince.text?.clear()
        binding.actvDistrict.text?.clear()
        binding.actvSubDistrict.text?.clear()
        binding.etDetail.text?.clear()

        binding.tilName.error = null
        binding.tilPlatform.error = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timeoutHandler.removeCallbacks(timeoutRunnable)
        _binding = null
    }
}
