package com.mobileappdevelopment.sharedpreferences

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceActivity
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var textField: EditText
    lateinit var sharePreference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textField=findViewById<EditText>(R.id.tf1)
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    override fun onResume() {
        super.onResume()
        writeData()
    }

    fun saveData()
    {
        sharePreference=getSharedPreferences("myData",MODE_PRIVATE)
        var editor=sharePreference.edit()
        editor.putString("value",textField.text.toString())
        editor.apply()
    }

    fun writeData()
    {
        sharePreference=getSharedPreferences("myData",MODE_PRIVATE)
        textField.setText(sharePreference.getString("value","meow"))
    }
}
