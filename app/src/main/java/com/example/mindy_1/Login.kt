package com.example.mindy_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    fun RegisterEmail(view: View){
        val intent = Intent(this, RegisterEmail::class.java)
        startActivity(intent)
    }
}