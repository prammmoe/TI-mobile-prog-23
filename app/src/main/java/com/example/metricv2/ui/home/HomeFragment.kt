package com.example.metricv2.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.metricv2.databinding.FragmentHomeBinding
import com.example.metricv2.viewmodel.HomeViewModel
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRandomFoods()
        observeRandomFood()
    }

    private fun observeRandomFood() {
        viewModel.observeRandomFoodLiveData().observe(viewLifecycleOwner
        ) { value ->
            Log.d("Test", "observeRandomFood: $value}")
            Glide.with(this@HomeFragment)
                .load(value.body()?.meals?.get(0))
                .into(binding.trendingSection)
        }
    }

}