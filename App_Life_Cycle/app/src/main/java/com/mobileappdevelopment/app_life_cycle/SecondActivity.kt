package com.mobileappdevelopment.app_life_cycle

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.d("Message", "On Second Activity Create")
    }
    override fun onStart() {
        super.onStart()

        Log.d("Message", "On Second Activity Start")
    }

    override fun onResume() {
        super.onResume()

        Log.d("Message", "On Second Activity Resume")
    }

    override fun onPause() {
        super.onPause()

        Log.d("Message", "On Second Activity Pause")
    }

    override fun onStop() {
        super.onStop()

        Log.d("Message", "On Second Activity Stop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("Message", "On Second Activity Destroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Message", "On Second Activity Restart")
    }
}