package com.example.metric

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class OnboardingThree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_3)

        val nextButton: Button = findViewById(R.id.buttonNext3)
        nextButton.setOnClickListener {
            val intent = Intent(this@OnboardingThree, Selection::class.java)
            startActivity(intent)
        }
    }
}