package com.example.metric

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.metric.databinding.RegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.FirebaseApp;

class Register : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding:RegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this);
        firebaseAuth = FirebaseAuth.getInstance()

        performRegist()

        val loginText: TextView = findViewById(R.id.buttonLogin)
        loginText.setOnClickListener {
            val intent = Intent(this@Register, Login::class.java)
            startActivity(intent)
        }
    }


//    ini function buat Auth Register Firebase
    private fun performRegist() {
        binding.RegButton.setOnClickListener {
            val fullName = binding.fullName.text.toString()
            val email = binding.emailReg.text.toString()
            val pass = binding.passReg.text.toString()
            val confirmPass = binding.confirmPassReg.text.toString()

            if (fullName.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this@Register, Login::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}