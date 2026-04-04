package com.personal.endpointmobile.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.personal.endpointmobile.R
import com.personal.endpointmobile.core.utils.AppDialog
import com.personal.endpointmobile.core.utils.gone
import com.personal.endpointmobile.core.utils.visible
import com.personal.endpointmobile.databinding.FragmentOrderResultBinding
import com.personal.endpointmobile.domain.repository.OrderRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class OrderResultFragment : Fragment() {

    @Inject lateinit var orderRepository: OrderRepository

    private var _binding: FragmentOrderResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.topBar.tvTitle.text = "รายการ Order"
        binding.topBar.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnAddOrder.setOnClickListener {
            findNavController().navigate(R.id.action_orderResultFragment_to_ordersFragment)
        }

        binding.bottomNav.btnOrders.setOnClickListener {
            findNavController().navigate(R.id.action_orderResultFragment_to_ordersFragment)
        }

        binding.bottomNav.btnSearch.setOnClickListener {
            findNavController().navigate(R.id.action_orderResultFragment_to_searchFragment)
        }

        loadOrders()
    }

    private fun loadOrders() {
        lifecycleScope.launch {
            val orders = orderRepository.getAll()
            if (orders.isEmpty()) {
                binding.rvOrders.gone()
                binding.tvEmpty.visible()
            } else {
                binding.tvEmpty.gone()
                binding.rvOrders.visible()
                binding.rvOrders.layoutManager = LinearLayoutManager(requireContext())
                binding.rvOrders.adapter = OrderResultAdapter(
                    orders = orders,
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
                    }
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
