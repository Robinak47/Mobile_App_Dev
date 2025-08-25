package com.mobileappdevelopment.datatransferactivitytofragment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

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

        val fgM: FragmentManager=supportFragmentManager
        val fgT: FragmentTransaction=fgM.beginTransaction()
        val dfm = DataFragment()


        btn.setOnClickListener {
            var nameData: String = name.text.toString()
            var ageData: Int = age.text.toString().toInt()

            val bundle= Bundle()
            bundle.putString("name",nameData)
            bundle.putInt("age",ageData)
            dfm.arguments=bundle

            fgT.add(R.id.frame, dfm)
            fgT.commit()
        }


    }
}