package com.mobileappdevelopment.intent

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class secondActivity : AppCompatActivity() {
    lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        result=findViewById<TextView>(R.id.result)
        var name:String=intent.getStringExtra("userInput1").toString()
        var age:Int=intent.getIntExtra("userInput2", 0)
        var numberArray=intent.getIntegerArrayListExtra("userArray")
        result.text="welcome "+name+" .Your Age is"+age+" array values are: \n"+numberArray!![0]+numberArray!![1]+numberArray!![2]+numberArray!![3]+numberArray!![4]
    }
}