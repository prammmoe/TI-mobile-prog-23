package com.example.metric

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
class Selection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selection)
        val registerButton: Button = findViewById(R.id.button_register)
        registerButton.setOnClickListener {
            val intent = Intent(this@Selection, register::class.java)
            startActivity(intent)
        }

        val loginButton: Button = findViewById(R.id.button_login)
        loginButton.setOnClickListener {
            val intent = Intent(this@Selection, login::class.java)
            startActivity(intent)
        }
    }
}