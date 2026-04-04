package com.personal.endpointmobile.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.personal.endpointmobile.R
import com.personal.endpointmobile.core.utils.visible
import com.personal.endpointmobile.databinding.FragmentSearchResultBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchResultFragment : Fragment() {

    private var _binding: FragmentSearchResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.getString("name") ?: ""
        val province = arguments?.getString("province") ?: ""
        val district = arguments?.getString("district") ?: ""
        val subDistrict = arguments?.getString("subDistrict") ?: ""
        val date = arguments?.getString("date") ?: ""

        binding.topBar.tvTitle.text = "ผลการค้นหา"
        binding.topBar.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.bottomNav.btnSearch.setOnClickListener {
            findNavController().navigate(R.id.action_searchResultFragment_to_searchFragment)
        }

        binding.bottomNav.btnOrders.setOnClickListener {
            findNavController().navigate(R.id.action_searchResultFragment_to_orderResultFragment)
        }

        // TODO: ส่ง filter ไปโหลดข้อมูล
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
