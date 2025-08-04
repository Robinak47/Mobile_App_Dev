package com.mobileappdevelopment.intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var age: EditText
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        name=findViewById<EditText>(R.id.name)
        age=findViewById<EditText>(R.id.age)
        btn=findViewById<Button>(R.id.btn)

        btn.setOnClickListener {

            var userName:String=name.text.toString()
            var userAge:Int=age.text.toString().toInt()
            var intent= Intent(this@MainActivity, secondActivity::class.java)
            intent.putExtra("userInput1", userName)
            intent.putExtra("userInput2", userAge)

            var numberArray: ArrayList<Int> = arrayListOf<Int>(10,20,30,40,50)
            intent.putIntegerArrayListExtra("userArray", numberArray)
            startActivity(intent)
        }


    }
}