package com.example.metric

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val loginText: Button = findViewById(R.id.buttonLogin)
        loginText.setOnClickListener {
            val intent = Intent(this@Register, Login::class.java)
            startActivity(intent)
        }

//        Handler untuk ambil inputan user, belum kepake saat ini, nanti akan kepake kalau udah ada home page
        val fullName = findViewById<EditText>(R.id.fullName)
        val textFullName = fullName.text

        val email = findViewById<EditText>(R.id.emailReg)
        val textEmail = email.text

        val pass = findViewById<EditText>(R.id.passReg)
        val textPassword = pass.text

        val confirmPass = findViewById<EditText>(R.id.confirmPassReg)
        val textConfirmPassword = confirmPass.text

    }
}