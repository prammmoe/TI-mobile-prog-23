package com.example.metricv2.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.metricv2.R
import com.example.metricv2.databinding.FragmentLoginBinding
import com.example.metricv2.viewmodel.LoginViewModel
import org.koin.android.ext.android.inject

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        init()
        observeData()
        return binding.root
    }

    private fun observeData() {
        with(viewModel) {
            observeIsLogin().observe(requireActivity()) {
                it.let { data ->
                    if(data != null) {
                        findNavController().navigate(R.id.login_to_parent)
                    } else {
                        Toast.makeText(requireContext(), "Wrong email and password", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun init() {
        with(binding) {
            loginButton.setOnClickListener {
                if(email.text.isNullOrBlank()) {
                    email.error = "Email must be filled"
                }

                if(password.text.isNullOrBlank()) {
                    password.error = "Password must be filled"
                }

                if(!email.text.isNullOrBlank() && !password.text.isNullOrBlank()) {
                    viewModel.getDataLogin(email.text.toString(), password.text.toString())
                }
            }

            buttonRegister.setOnClickListener {
                findNavController().navigate(R.id.if_not_login_to_register)
            }
        }
    }

}