package com.mobileappdevelopment.fragment_transaction

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity() {

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
        val fregmentManager: androidx.fragment.app.FragmentManager=supportFragmentManager
        val fregmentTransaction: FragmentTransaction = fregmentManager.beginTransaction()
        val firstFregment= FirstFragment()
        fregmentTransaction.add(R.id.frame, firstFregment)
        fregmentTransaction.commit()

        btn=findViewById<Button>(R.id.btn)

        btn.setOnClickListener {

            /*val secondFragmentManager: androidx.fragment.app.FragmentManager=supportFragmentManager
            val secondFragmentTransaction: FragmentTransaction=secondFragmentManager.beginTransaction()
            val secondFragment= SecondFragment()
            secondFragmentTransaction.replace(R.id.frame, secondFragment)
            secondFragmentTransaction.commit()*/

            val intent: Intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}