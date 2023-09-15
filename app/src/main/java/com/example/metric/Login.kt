package com.example.metric

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.metric.databinding.LoginBinding
import com.example.metric.databinding.RegisterBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.zip.Inflater

class Login: AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: LoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Ini kalo udah regis langsung klik text login aja
        val registerText: TextView = findViewById(R.id.buttonRegister)
        registerText.setOnClickListener {
            val intent = Intent(this@Login, Register::class.java)
            startActivity(intent)
        }

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

        // ini Test
        val loginButton: Button = findViewById(R.id.login_login)
        loginButton.setOnClickListener {
            val intent = Intent(this, MainPage::class.java)
            startActivity(intent)
        }
    }
}