package com.example.metric

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val nextButton: Button = findViewById(R.id.buttonNext)
        nextButton.setOnClickListener {
            val intent = Intent(this@MainActivity2, OnboardingTwo::class.java)
            startActivity(intent)
        }
    }

}