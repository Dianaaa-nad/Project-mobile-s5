package com.example.mindy_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun RegisterEmail(view: View){
        val intent = Intent(this, RegisterEmail::class.java)
        startActivity(intent)
    }
    fun Login(view: View){
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }
}