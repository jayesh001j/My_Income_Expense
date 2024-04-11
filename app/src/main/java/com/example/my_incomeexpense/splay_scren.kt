package com.example.my_incomeexpense

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class splay_scren : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000 // 3 seconds


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splay_scren)



            Handler().postDelayed({
                // This method will be executed once the timer is over
                // Start your app's main activity
                startActivity(Intent(this, MainActivity::class.java))

                // Close this activity
                finish()
            }, SPLASH_TIME_OUT)
        }
    }



