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
import androidx.recyclerview.widget.LinearLayoutManager
import com.personal.endpointmobile.R
import com.personal.endpointmobile.core.sync.SheetSyncService
import com.personal.endpointmobile.core.utils.AppDialog
import com.personal.endpointmobile.core.utils.OrderFilterStore
import com.personal.endpointmobile.core.utils.gone
import com.personal.endpointmobile.core.utils.visible
import com.personal.endpointmobile.databinding.FragmentOrderResultBinding
import com.personal.endpointmobile.domain.model.OrderFilter
import com.personal.endpointmobile.domain.repository.OrderRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class OrderResultFragment : Fragment() {

    @Inject lateinit var orderRepository: OrderRepository

    private var _binding: FragmentOrderResultBinding? = null
    private val binding get() = _binding!!

    private lateinit var filterStore: OrderFilterStore
    private var activeFilter = OrderFilter()
    private var cardMode = OrderResultAdapter.Mode.DELETE

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
        _binding = FragmentOrderResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filterStore = OrderFilterStore(requireContext())
        val saved = filterStore.load()
        activeFilter = if (saved.isEmpty) OrderFilter(status = "ใหม่") else saved

        binding.topBar.tvTitle.text = "ORDERS"
        binding.topBar.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnNewOrder.setOnClickListener {
            AddOrderDialog.newInstance { order ->
                lifecycleScope.launch {
                    orderRepository.insert(order)
                    loadOrders()
                    AppDialog.show(
                        fragment = this@OrderResultFragment,
                        type = AppDialog.Type.SUCCESS,
                        title = "สำเร็จ",
                        message = "เพิ่ม Order สำเร็จ"
                    )
                }
            }.show(parentFragmentManager, "AddOrderDialog")
        }

        binding.btnSubmit.setOnClickListener {
            cardMode = OrderResultAdapter.Mode.SUBMIT
            lifecycleScope.launch { loadOrders() }
        }

        binding.btnDeleteOrder.setOnClickListener {
            cardMode = OrderResultAdapter.Mode.DELETE
            lifecycleScope.launch { loadOrders() }
        }

        binding.btnFilter.setOnClickListener {
            FilterOrderDialog.newInstance(
                initialFilter = activeFilter,
                onApply = { filter ->
                    activeFilter = filter
                    filterStore.save(filter)
                    showSpinnerWithTimeout()
                    lifecycleScope.launch {
                        loadOrders()
                        hideSpinner()
                    }
                },
                onReset = {
                    activeFilter = OrderFilter(status = "ใหม่")
                    filterStore.save(activeFilter)
                    showSpinnerWithTimeout()
                    lifecycleScope.launch {
                        loadOrders()
                        hideSpinner()
                    }
                },
                onDraft = { draft ->
                    filterStore.save(draft)
                }
            ).show(parentFragmentManager, "FilterOrderDialog")
        }

        binding.btnSyncSheet.setOnClickListener {
            lifecycleScope.launch {
                binding.btnSyncSheet.isEnabled = false
                binding.btnSyncSheet.text = "กำลัง Sync..."
                showSpinnerWithTimeout()

                val orders = orderRepository.getAll()
                SheetSyncService.sync(orders)
                    .onSuccess { count ->
                        hideSpinner()
                        AppDialog.show(
                            fragment = this@OrderResultFragment,
                            type = AppDialog.Type.SUCCESS,
                            title = "Sync สำเร็จ",
                            message = "ส่งข้อมูล $count รายการไปยัง Google Sheets แล้ว"
                        )
                    }
                    .onFailure { error ->
                        hideSpinner()
                        AppDialog.show(
                            fragment = this@OrderResultFragment,
                            type = AppDialog.Type.WARNING,
                            title = "Sync ล้มเหลว",
                            message = error.message ?: "เกิดข้อผิดพลาด กรุณาลองใหม่"
                        )
                    }

                binding.btnSyncSheet.isEnabled = true
                binding.btnSyncSheet.text = "Sync to Google Sheet"
            }
        }

        binding.bottomNav.btnOrders.setOnClickListener { }
        binding.bottomNav.btnMenu.setOnClickListener { }

        lifecycleScope.launch { loadOrders() }
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

    private fun updateFilterButton() {
        binding.btnFilter.text = "กรอง"
    }

    private suspend fun loadOrders() {
        val orders = if (activeFilter.isEmpty) {
            orderRepository.getAll()
        } else {
            orderRepository.filter(activeFilter)
        }

        if (orders.isEmpty()) {
            binding.rvOrders.gone()
            binding.tvEmpty.visible()
            binding.tvEmpty.text = if (!activeFilter.isEmpty) {
                "ไม่พบรายการที่ตรงกับเงื่อนไข"
            } else {
                "ยังไม่มีรายการ Order"
            }
        } else {
            binding.tvEmpty.gone()
            binding.rvOrders.visible()
            binding.rvOrders.layoutManager = LinearLayoutManager(requireContext())
            binding.rvOrders.adapter = OrderResultAdapter(
                orders = orders,
                mode = cardMode,
                onCardClick = { order ->
                    EditOrderDialog.newInstance(order) { updated ->
                        lifecycleScope.launch {
                            orderRepository.updateById(updated)
                            loadOrders()
                        }
                    }.show(parentFragmentManager, "EditOrderDialog")
                },
                onDeleteClick = { order ->
                    AppDialog.show(
                        fragment = this@OrderResultFragment,
                        type = AppDialog.Type.WARNING,
                        title = "ยืนยันการลบ",
                        message = "ต้องการลบรายการ \"${order.name}\" ใช่ไหม?",
                        positiveText = "ยืนยัน",
                        negativeText = "ยกเลิก",
                        onPositive = {
                            lifecycleScope.launch {
                                orderRepository.deleteById(order.id)
                                loadOrders()
                            }
                        }
                    )
                },
                onSubmitClick = { order ->
                    AppDialog.show(
                        fragment = this@OrderResultFragment,
                        type = AppDialog.Type.INFO,
                        title = "ยืนยันการส่งงาน",
                        message = "ต้องการส่งงานรายการ \"${order.name}\" ใช่ไหม?",
                        positiveText = "ยืนยัน",
                        negativeText = "ยกเลิก",
                        onPositive = {
                            lifecycleScope.launch {
                                orderRepository.updateById(order.copy(status = "ส่งงานแล้ว"))
                                loadOrders()
                            }
                        }
                    )
                }
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timeoutHandler.removeCallbacks(timeoutRunnable)
        _binding = null
    }
}
