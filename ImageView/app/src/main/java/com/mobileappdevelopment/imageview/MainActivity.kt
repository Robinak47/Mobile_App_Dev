package com.mobileappdevelopment.imageview

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var img:ImageView
    lateinit var tgBtn:ToggleButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        img=findViewById<ImageView>(R.id.logo)
        tgBtn=findViewById<ToggleButton>(R.id.tg)

        tgBtn.setOnCheckedChangeListener { compoundButton, isChecked->

            if(isChecked)
            {
                //img.setImageResource(R.drawable.samsung)
                img.visibility= View.INVISIBLE
            }

            else
            {

            }
        }
    }
}