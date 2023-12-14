package com.example.metricv2.ui.menu.trends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metricv2.data.remote.response.MealCategory
import com.example.metricv2.databinding.FragmentTrendsBinding
import com.example.metricv2.ui.menu.trends.TrendsAdapter
import com.example.metricv2.viewmodel.TrendsViewModel
import org.koin.android.ext.android.inject

class TrendsFragment : Fragment() {
    private var _binding: FragmentTrendsBinding? = null
    private val binding get() = _binding
    private val viewModel: TrendsViewModel by inject()
    private var list: List<MealCategory> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTrendsBinding.inflate(inflater, container, false)
        init()
        observerData()
        return binding?.root
    }

    private fun observerData() {
        with(viewModel) {
            observeRandomFoodLiveData().observe(requireActivity()) {
                it.let { data ->
                    list = data.body()?.meals ?: listOf()
                    with(binding!!.rvFood) {
                        adapter = TrendsAdapter(list)
                        layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }
        }
    }

    private fun init() {
        viewModel.getAllFoods()
    }
}