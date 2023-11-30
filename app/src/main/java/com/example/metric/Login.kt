package com.example.metric

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.metric.databinding.LoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.FirebaseApp;

class Login: AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding:LoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Guide user to login if they already register
        val registerText: TextView = findViewById(R.id.buttonRegister)
        registerText.setOnClickListener {
            val intent = Intent(this@Login, Register::class.java)
            startActivity(intent)
        }

//        Main init to get into Firebase Auth
        FirebaseApp.initializeApp(this);
        firebaseAuth = FirebaseAuth.getInstance()
        binding.loginLogin.setOnClickListener {
            val email = binding.emailLog.text.toString()
            val pass = binding.passLog.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this@Login, MainPage::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Please fill all fields.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}