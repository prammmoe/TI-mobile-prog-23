package com.example.metric

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.metric.databinding.RegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.FirebaseApp
import android.text.method.HideReturnsTransformationMethod;

class Register : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding:RegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase App
        FirebaseApp.initializeApp(this);
        firebaseAuth = FirebaseAuth.getInstance()

        // Calls performRegist when user clicked Register Button
        performRegist()

        // Login text link for users who already registered
        val loginText: TextView = findViewById(R.id.buttonLogin)
        loginText.setOnClickListener {
            val intent = Intent(this@Register, Login::class.java)
            startActivity(intent)
        }
    }

    // Function to register user using Firebase Auth
    private fun performRegist() {
        binding.RegButton.setOnClickListener {
            // Get users identity
            val fullName = binding.fullName.text.toString()
            val email = binding.emailReg.text.toString()
            val pass = binding.passReg.text.toString()
            val confirmPass = binding.confirmPassReg.text.toString()

            // Checks if users identity not empty
            if (fullName.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                // Checks if inputed password is equals to confirmed password
                if (pass == confirmPass) {
                    // Add user to Firebase Auth and Create user ID
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        // If successful, then guide user to Login
                        if (it.isSuccessful) {
                            val intent = Intent(this@Register, Login::class.java)
                            startActivity(intent)
                        // If not successful, toast error
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                // Toast password is not matching error
                } else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            // Checks if fields empty, then toast error.
            } else {
                Toast.makeText(this, "Please fill all fields.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}