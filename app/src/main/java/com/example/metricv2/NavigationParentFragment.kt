package com.example.metricv2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.metricv2.databinding.FragmentNavigationParentBinding
import com.example.metricv2.ui.home.HomeFragment
import com.example.metricv2.ui.menu.insight.InsightFragment
import com.example.metricv2.ui.menu.schedule.ScheduleFragment
import com.example.metricv2.ui.menu.trends.TrendsFragment


class NavigationParentFragment : Fragment() {
    private var _binding: FragmentNavigationParentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationParentBinding.inflate(inflater, container, false)

        val homeFragment = HomeFragment()
        val trendsFragment = TrendsFragment()
        val scheduleFragment = ScheduleFragment()
        val insightFragment = InsightFragment()

        setCurrentFragment(homeFragment)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_home -> setCurrentFragment(homeFragment)
                R.id.nav_trends -> setCurrentFragment(trendsFragment)
                R.id.nav_schedule -> setCurrentFragment(scheduleFragment)
                R.id.nav_insight -> setCurrentFragment(insightFragment)

            }
            true
        }
        return binding.root
    }

    private fun setCurrentFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.parent_fragment, fragment)
            commit()
        }
    }
}