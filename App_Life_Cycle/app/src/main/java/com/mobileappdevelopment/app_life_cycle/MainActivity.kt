package com.mobileappdevelopment.app_life_cycle

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var btn:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn=findViewById<Button>(R.id.btn)

        btn.setOnClickListener {
            var intent= Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }

        Log.d("Message", "On Main Activity Create")
    }

    override fun onStart() {
        super.onStart()

        Log.d("Message", "On Main Activity Start")
    }

    override fun onResume() {
        super.onResume()

        Log.d("Message", "On Main Activity Resume")
    }

    override fun onPause() {
        super.onPause()

        Log.d("Message", "On Main Activity Pause")
    }

    override fun onStop() {
        super.onStop()

        Log.d("Message", "On Main Activity Stop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("Message", "On Main Activity Destroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Message", "On Main Activity Restart")
    }
}