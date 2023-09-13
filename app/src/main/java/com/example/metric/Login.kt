package com.example.metric

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Login: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val registerText: TextView = findViewById(R.id.buttonRegister)
        registerText.setOnClickListener {
            val intent = Intent(this@Login, Register::class.java)
            startActivity(intent)
        }

        val email = findViewById<EditText>(R.id.emailLog)
        val textEmail = email.text

        val pass = findViewById<EditText>(R.id.passLog)
        val textPassword = pass.text
    }
}