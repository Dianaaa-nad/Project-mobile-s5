package com.example.mindy_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private var email: EditText? = null
    private var password: EditText? = null
    private var login: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        FirebaseApp.initializeApp(this)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)
        auth = FirebaseAuth.getInstance()

        login?.setOnClickListener {
            val userEmail = email?.text?.toString()
            val userPassword = password?.text?.toString()

            if (userEmail?.isNotEmpty() == true && userPassword?.isNotEmpty() == true) {
                // Disable the login button and show a progress indicator if needed

                auth.signInWithEmailAndPassword(userEmail, userPassword)
                    .addOnCompleteListener(this) { task ->
                        // Re-enable the login button and hide the progress indicator if needed

                        if (task.isSuccessful) {
                            // Login successful
                            // You can navigate to the main activity or perform other actions
                            startActivity(Intent(this@Login, Home::class.java))
                        } else {
                            // If login fails, display a message to the user.
                            // You can handle specific error cases here.
                            val errorMessage = task.exception?.message ?: "Login failed"
                            Toast.makeText(this@Login, errorMessage, Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                // Handle empty email or password fields
                Toast.makeText(this, "Please fill in all fields correctly", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun RegisterEmail(view: View) {
        val intent = Intent(this, RegisterEmail::class.java)
        startActivity(intent)
    }
}
