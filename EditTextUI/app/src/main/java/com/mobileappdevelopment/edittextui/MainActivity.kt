package com.mobileappdevelopment.edittextui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mobileappdevelopment.edittextui.R.id.textView3

class MainActivity : AppCompatActivity() {
 lateinit var userName: EditText
 lateinit var age: EditText
 lateinit var email: EditText
 lateinit var password: EditText
 lateinit var phone: EditText
 lateinit var btn: Button
 lateinit var textView2:TextView
 lateinit var maleRB: RadioButton
 lateinit var femaleRB:RadioButton
 lateinit var cCB: CheckBox
 lateinit var csCB: CheckBox
 lateinit var kCB: CheckBox

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

        userName=findViewById(R.id.userName)
        age=findViewById(R.id.age)
        email=findViewById(R.id.email)
        password=findViewById(R.id.password)
        phone=findViewById(R.id.phone)
        btn=findViewById(R.id.submit)
        textView2=findViewById(R.id.textView3)
        maleRB=findViewById<RadioButton>(R.id.maleRB)
        femaleRB=findViewById<RadioButton>(R.id.femaleRB)
        cCB=findViewById<CheckBox>(R.id.cCB)
        csCB=findViewById<CheckBox>(R.id.csCB)
        kCB=findViewById<CheckBox>(R.id.kCB)


        btn.setOnClickListener {
            var value = userName.text.toString()
            value+=" ,"+age.text.toString()
            value+=" ,"+email.text.toString()
            value+=" ,"+phone.text.toString()
            value+=", "+password.text.toString()
            if(maleRB.isChecked)
            {
                value+=", "+maleRB.text
            }

            if(femaleRB.isChecked)
            {
                value+=", "+femaleRB.text
            }

            if(cCB.isChecked)
            {
                value+=", "+cCB.text
            }

            if(csCB.isChecked)
            {
                value+=", "+csCB.text
            }

            if(kCB.isChecked)
            {
                value+=", "+kCB.text
            }
            textView2.visibility= View.VISIBLE
            textView2.setText(value)
        }



    }
}
