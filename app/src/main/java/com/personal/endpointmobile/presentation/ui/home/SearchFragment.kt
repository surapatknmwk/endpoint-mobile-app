package com.personal.endpointmobile.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.datepicker.MaterialDatePicker
import com.personal.endpointmobile.R
import com.personal.endpointmobile.core.utils.gone
import com.personal.endpointmobile.core.utils.setupLocationDropdowns
import com.personal.endpointmobile.databinding.FragmentSearchBinding
import com.personal.endpointmobile.presentation.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.topBar.tvTitle.text = getString(R.string.title_search)
        binding.topBar.btnBack.gone()

        val user = authViewModel.currentUser
        binding.tvWelcome.text = getString(R.string.welcome_message, user?.displayName ?: "User")

        binding.btnSignOut.setOnClickListener {
            authViewModel.signOut()
            findNavController().navigate(R.id.action_searchFragment_to_loginFragment)
        }

        val resetLocation = setupLocationDropdowns(
            binding.tilProvince,
            binding.tilDistrict,
            binding.tilSubDistrict,
        )

        setupDatePicker()
        setupSearch(resetLocation)
    }

    private fun setupSearch(resetLocation: () -> Unit) {
        val navigateToResult = {
            val args = Bundle().apply {
                putString("name", binding.etName.text?.toString() ?: "")
                putString("province", binding.actvProvince.text?.toString() ?: "")
                putString("district", binding.actvDistrict.text?.toString() ?: "")
                putString("subDistrict", binding.actvSubDistrict.text?.toString() ?: "")
                putString("date", binding.etDate.text?.toString() ?: "")
            }
            findNavController().navigate(R.id.action_searchFragment_to_searchResultFragment, args)
        }

        binding.btnSearchFilter.setOnClickListener { navigateToResult() }

        binding.bottomNav.btnOrders.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_orderResultFragment)
        }

        binding.btnReset.setOnClickListener {
            binding.etName.text?.clear()
            resetLocation()
            binding.etDate.text?.clear()
        }
    }

    private fun setupDatePicker() {
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("เลือกวันที่")
            .build()

        val openDatePicker = {
            if (!datePicker.isAdded) {
                datePicker.show(parentFragmentManager, "DATE_PICKER")
            }
        }

        datePicker.addOnPositiveButtonClickListener { selection ->
            val formatted = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(selection))
            binding.etDate.setText(formatted)
        }

        binding.etDate.setOnClickListener { openDatePicker() }
        binding.tilDate.setEndIconOnClickListener { openDatePicker() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
