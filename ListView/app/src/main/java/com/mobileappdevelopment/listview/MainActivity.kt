package com.mobileappdevelopment.listview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(){
    lateinit var listView: ListView

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

        listView=findViewById<ListView>(R.id.listView)

        var studentlist=resources.getStringArray(R.array.Students)
        var arrayAdapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,studentlist)
        listView.adapter=arrayAdapter
        listView.setOnItemClickListener{ AdapterView, View, position, id ->
            var value=AdapterView.getItemAtPosition(position)
            Toast.makeText(this, "Student Clicked: "+value, Toast.LENGTH_SHORT).show()

        }






    }


}

