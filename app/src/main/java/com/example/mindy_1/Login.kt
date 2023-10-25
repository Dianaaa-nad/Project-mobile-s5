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
    private var firebaseAuth: FirebaseAuth? = null
    private var email: EditText? = null
    private var password: EditText? = null
    private var konfirmasipw: EditText? = null
    private var login: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        firebaseAuth = FirebaseAuth.getInstance()
        FirebaseApp.initializeApp(this)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)

        login?.setOnClickListener {
            firebaseAuth?.signInWithEmailAndPassword(email?.text.toString(), password?.text.toString())
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this, Home::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                    }
                }
        }

    }
    fun RegisterEmail(view: View){
        val intent = Intent(this, RegisterEmail::class.java)
        startActivity(intent)
    }
}