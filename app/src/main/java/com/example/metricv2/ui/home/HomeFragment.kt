package com.example.metricv2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.metricv2.R
import com.example.metricv2.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    private fun init() {
        with(binding) {
            trendingSection.setOnClickListener {
                findNavController().navigate(R.id.if_not_login_to_register)
            }
        }
    }
}