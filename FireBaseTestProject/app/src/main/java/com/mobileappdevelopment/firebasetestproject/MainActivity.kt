package com.mobileappdevelopment.firebasetestproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var textData : EditText
    lateinit var btn: Button

    val database : FirebaseDatabase = FirebaseDatabase.getInstance()

    val ref: DatabaseReference = database.reference.child("Student")

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

        textData=findViewById<EditText>(R.id.td1)
        btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener {
            var value:String = textData.text.toString()

            ref.child("student1").child("Scholarship_Percentage").setValue(value)
        }

    }
}