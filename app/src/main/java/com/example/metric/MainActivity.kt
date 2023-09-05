package com.example.metric

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
            WindowManager.LayoutParams.FLAG_BLUR_BEHIND
        )
        setContentView(R.layout.activity_main)
        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(
                this@MainActivity,
                OnboardingOne::class.java
            )
            startActivity(i)

            finish()
        }, 3000)
    }
}

