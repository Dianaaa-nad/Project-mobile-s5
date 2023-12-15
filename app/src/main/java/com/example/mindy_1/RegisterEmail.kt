package com.example.mindy_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class RegisterEmail : AppCompatActivity() {

    private var firebaseAuth: FirebaseAuth? = null
    private var email: EditText? = null
    private var password: EditText? = null
    private var konfirmasipw: EditText? = null
    private var daftar: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_email)

        firebaseAuth = FirebaseAuth.getInstance()

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        konfirmasipw = findViewById(R.id.konfirmasipw)
        daftar = findViewById(R.id.daftar)

        daftar?.setOnClickListener {
            val userEmail = email?.text.toString()
            val userPassword = password?.text.toString()
            val confirmPassword = konfirmasipw?.text.toString()

            if (userEmail.isNotEmpty() && userPassword.isNotEmpty() && userPassword == confirmPassword) {
                registerUser(userEmail, userPassword)
            } else {
                Toast.makeText(this, "Please fill in all fields correctly", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registerUser(email: String, password: String) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                firebaseAuth?.createUserWithEmailAndPassword(email, password)?.await()
                // Registration successful
                Toast.makeText(this@RegisterEmail, "Registration successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@RegisterEmail, Home::class.java))
                finish()
            } catch (e: Exception) {
                // Handle registration failure
                when (e) {
                    is FirebaseAuthInvalidUserException, is FirebaseAuthInvalidCredentialsException -> {
                        Toast.makeText(this@RegisterEmail, "Invalid email or password", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        Toast.makeText(this@RegisterEmail, "Registration failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    fun login(view: View) {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }
}
