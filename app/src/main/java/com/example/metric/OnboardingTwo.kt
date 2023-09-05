package com.example.metric

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class OnboardingTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_2)

        val nextButton: Button = findViewById(R.id.buttonNext2)
        nextButton.setOnClickListener {
            val intent = Intent(this@OnboardingTwo, OnboardingThree::class.java)
            startActivity(intent)
        }
    }

}