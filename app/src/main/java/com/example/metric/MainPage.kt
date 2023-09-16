package com.example.metric

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)
        bottomNavColor()
    }

    private fun bottomNavColor() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)

        val colorStateList = ContextCompat.getColorStateList(this, R.color.button_nav_icon_colors)
        bottomNavigationView.itemIconTintList = colorStateList

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Handle Home item click
                    val selectedColor = ContextCompat.getColor(this, R.color.metric_green)
                    // Change icon color if needed
                    item.icon?.setTint(selectedColor)
                }
                R.id.nav_trends -> {
                    val selectedColor = ContextCompat.getColor(this, R.color.metric_green)
                    // Change icon color if needed
                    item.icon?.setTint(selectedColor)
                }
                R.id.nav_schedule -> {
                    val selectedColor = ContextCompat.getColor(this, R.color.metric_green)
                    // Change icon color if needed
                    item.icon?.setTint(selectedColor)
                }
                R.id.nav_insight -> {
                    val selectedColor = ContextCompat.getColor(this, R.color.metric_green)
                    // Change icon color if needed
                    item.icon?.setTint(selectedColor)
                }
            }
            true // Return true to indicate the item selection is handled
        }
    }
}