package com.example.metricv2.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.metricv2.R
import com.example.metricv2.data.local.entity.UserEntity
import com.example.metricv2.databinding.FragmentRegisterBinding
import com.example.metricv2.viewmodel.RegisterViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RegisterViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        init()
        observeData()
        return binding.root
    }

    private fun observeData() {
        with(viewModel) {
            observeIsRegister().observe(viewLifecycleOwner) {
                it.let { data ->
                    if (data) {
                        findNavController().navigate(R.id.register_to_login)
                    } else {
                        Toast.makeText(requireContext(), "Email already been registered", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun init() {
//        binding.RegButton.setOnClickListener {
//            val name = binding.fullName.text.toString()
//            val email = binding.email.text.toString()
//            val password = binding.password.text.toString()
//            val user = UserEntity(0, name, email, password)
//            viewModel.insertUser(user)
//        }
        with(binding) {
            RegButton.setOnClickListener {
                val name = binding.fullName.text.toString()
                val emailReg = binding.email.text.toString()
                val passwordReg = binding.password.text.toString()

                if (!fullName.text.isNullOrBlank() && !email.text.isNullOrBlank() && !password.text.isNullOrBlank() && !confirmPassword.text.isNullOrBlank()) {
                    val user = UserEntity(0, name, emailReg, passwordReg)
                    viewModel.insertUser(user)
                } else {
                    if (fullName.text.isNullOrBlank()) {
                        fullName.error = "Please enter your name"
                    }
                    if (email.text.isNullOrBlank()) {
                        email.error = "Email must be filled"
                    }
                    if (password.text.isNullOrBlank()) {
                        password.error = "Plase enter your password"
                    }
                    if (confirmPassword.text.isNullOrBlank()) {
                        confirmPassword.error = "Please confirm your password"
                    }
                }
            }
         }

        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.if_not_register_to_login)
        }
    }
}