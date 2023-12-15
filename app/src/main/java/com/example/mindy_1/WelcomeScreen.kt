package com.example.mindy_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class WelcomeScreen : AppCompatActivity() {
    private var Lanjutkan: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)

        Lanjutkan = findViewById(R.id.lanjutkan)
    }

    fun Lanjutkan(view: View) {
        val intent = Intent(this, WelcomeScreen2::class.java)
        startActivity(intent)
    }
}