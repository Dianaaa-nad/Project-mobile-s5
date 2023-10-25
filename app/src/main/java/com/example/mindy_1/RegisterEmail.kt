package com.example.mindy_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.AuthResult
import com.google.firebase.FirebaseApp
import android.widget.Toast

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
        FirebaseApp.initializeApp(this)

        email = findViewById(R.id.email) // Replace 'R.id.email' with the actual ID of your EditText in the layout.
        password = findViewById(R.id.password) // Replace 'R.id.password' with the actual ID of your EditText in the layout.
        konfirmasipw = findViewById(R.id.konfirmasipw) // Replace 'R.id.konfirmasipw' with the actual ID of your EditText in the layout.
        daftar = findViewById(R.id.daftar) // Replace 'R.id.daftar' with the actual ID of your Button in the layout.

        daftar?.setOnClickListener {
            firebaseAuth?.createUserWithEmailAndPassword(email?.text.toString(), password?.text.toString())
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Registered successfully", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                    }
                }
        }
    }

    fun Login(view: View) {
        val intent = Intent(this, Login::class.java) // Change 'Login::class.java' to the actual LoginActivity class name.
        startActivity(intent)
    }
}
