package com.example.metric

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        auth = Firebase.auth

        val loginText: Button = findViewById(R.id.buttonLogin)
        loginText.setOnClickListener {
            val intent = Intent(this@Register, Login::class.java)
            startActivity(intent)
        }

        val regisBut: Button = findViewById(R.id.RegButton)
        regisBut.setOnClickListener {
            performSignUp()
        }
    }

    private fun performSignUp() {
        val fullName = findViewById<EditText>(R.id.fullName)
        val textFullName = fullName.text.toString()

        val email = findViewById<EditText>(R.id.emailReg)
        val textEmail = email.text.toString()

        val pass = findViewById<EditText>(R.id.passReg)
        val textPassword = pass.text.toString()

        val confirmPass = findViewById<EditText>(R.id.confirmPassReg)
        val textConfirmPassword = confirmPass.text.toString()

        if (fullName.text.isEmpty() || email.text.isEmpty() || pass.text.isEmpty() || confirmPass.text.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(textEmail, textConfirmPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent = Intent(this@Register, MainPage::class.java)
                    startActivity(intent)

                    Toast.makeText(
                        baseContext,
                        "Success",
                        Toast.LENGTH_SHORT,
                    ).show()

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error occured ${it.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
    }
}