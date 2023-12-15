package com.example.mindy_1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNav)

        // Set an item selected listener
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    // Handle the Home item selection
                }
                R.id.chat -> {
                    val intent = Intent(this, Chat::class.java)
                    startActivity(intent)
                }
//                R.id.navigation_notifications -> {
//                    // Handle the Notifications item selection
//                }
            }
            true // Return true to indicate item selection was handled
        }
    }
}