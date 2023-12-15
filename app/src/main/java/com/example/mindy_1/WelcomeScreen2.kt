package com.example.mindy_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class WelcomeScreen2 : AppCompatActivity() {
    private var Oke: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen2)

        Oke = findViewById(R.id.Oke)
    }

    fun oke(view: View) {
        val intent = Intent(this, Nama::class.java)
        startActivity(intent)
    }
}