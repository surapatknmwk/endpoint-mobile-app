package com.personal.endpointmobile.presentation.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.personal.endpointmobile.R
import com.personal.endpointmobile.core.utils.Resource
import com.personal.endpointmobile.core.utils.collectFlow
import com.personal.endpointmobile.core.utils.gone
import com.personal.endpointmobile.core.utils.showToast
import com.personal.endpointmobile.core.utils.visible
import com.personal.endpointmobile.databinding.FragmentRegisterBinding
import com.personal.endpointmobile.presentation.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val name = binding.etDisplayName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            viewModel.signUp(email, password, name)
        }

        collectFlow(viewModel.authState) { state ->
            when (state) {
                is Resource.Loading -> {
                    binding.progressBar.visible()
                    binding.btnRegister.isEnabled = false
                }
                is Resource.Success -> {
                    binding.progressBar.gone()
                    findNavController().navigate(R.id.action_registerFragment_to_orderResultFragment)
                }
                is Resource.Error -> {
                    binding.progressBar.gone()
                    binding.btnRegister.isEnabled = true
                    showToast(state.message)
                }
                null -> {
                    binding.progressBar.gone()
                    binding.btnRegister.isEnabled = true
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
