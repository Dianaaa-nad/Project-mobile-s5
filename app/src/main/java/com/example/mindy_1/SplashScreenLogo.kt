package com.example.mindy_1

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashScreenLogo : AppCompatActivity() {

    // Define SPLASH_SCREEN constant with the desired delay
    private val SPLASH_SCREEN: Long = 2000 // Adjust the delay as needed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash_screen_logo)
        var logoanimation: Animation
        var logo: ImageView

        logoanimation = AnimationUtils.loadAnimation(this, R.anim.logoanimation)

        logo = findViewById<ImageView>(R.id.logo)

        logo.animation = logoanimation

        Handler().postDelayed({
            val intent = Intent(this@SplashScreenLogo, SplashScreen2::class.java)
            val pairs: Array<Pair<View, String>> = arrayOf(Pair(logo, "logo_image"))
            val options = ActivityOptions.makeSceneTransitionAnimation(
                this@SplashScreenLogo,
            )
            startActivity(intent, options.toBundle())
        }, SPLASH_SCREEN)
    }
}
