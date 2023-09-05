package com.example.metric

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
class OnboardingOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_1)

        val nextButton: Button = findViewById(R.id.buttonNext)
        nextButton.setOnClickListener {
            val intent = Intent(this@OnboardingOne, OnboardingTwo::class.java)
            startActivity(intent)
        }

        val skipButton: Button = findViewById(R.id.buttonSkip)
        skipButton.setOnClickListener {
            val intent = Intent(this@OnboardingOne, Selection::class.java)
            startActivity(intent)
        }
    }

}