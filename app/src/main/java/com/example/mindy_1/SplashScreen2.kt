package com.example.mindy_1

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle

class SplashScreen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen2)

        val thread = Thread {
            try {
                Thread.sleep(3000)
                val intent = Intent(this@SplashScreen2, MainActivity::class.java)
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                // Handle exceptions here if necessary
            }
        }
        thread.start()
    }
}
