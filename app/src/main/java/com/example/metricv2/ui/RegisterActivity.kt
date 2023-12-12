package com.example.metricv2.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.metricv2.R
import com.example.metricv2.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity(){
    var isExist = false
    private val RegButton = findViewById<Button>(R.id.RegButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val userRepository = ViewModelProvider(this@RegisterActivity)[RegisterViewModel::class.java]
        RegButton.setOnClickListener {
            if(validation()) {
                userRepository.getData
            }
        }
    }

    private fun validation(): Boolean {
        val fullName = findViewById<EditText>(R.id.fullName)
        val email = findViewById<EditText>(R.id.emailReg)
        val pass = findViewById<EditText>(R.id.passReg)
        val confirmReg = findViewById<EditText>(R.id.confirmPassReg)

        if (fullName.text.isNullOrEmpty()) {
            Toast.makeText(this@RegisterActivity, " Enter Full Name ", Toast.LENGTH_LONG).show()
            return false
        }

        if (email.text.isNullOrEmpty()) {
            Toast.makeText(this@RegisterActivity, " Enter Email ", Toast.LENGTH_LONG).show()
            return false
        }
        if (pass.text.isNullOrEmpty()) {
            Toast.makeText(this@RegisterActivity, " Enter Password ", Toast.LENGTH_LONG).show()
            return false
        }
        if (confirmReg.text.isNullOrEmpty() && confirmReg.text != pass.text) {
            Toast.makeText(this@RegisterActivity, " Password must same", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
}