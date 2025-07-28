package com.mobileappdevelopment.datepickertest

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.Month
import java.time.Year

class MainActivity : AppCompatActivity() {

    lateinit var dateTxt:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        dateTxt=findViewById<TextView>(R.id.datepk)

        dateTxt.setOnClickListener {
            showDatePickerDialog()
            Toast.makeText(this, "user is going to select a date",Toast.LENGTH_LONG).show()
        }
    }

    @SuppressLint("SetTextI18n")
    fun showDatePickerDialog()
    {
        var calender=Calendar.getInstance()
        var year=calender.get(Calendar.YEAR)
        var month=calender.get(Calendar.MONTH)
        var day=calender.get(Calendar.DAY_OF_MONTH)

        var datePickerDialog=DatePickerDialog(this, {_, seletedYear, selectedMonth, selectedDay ->
            dateTxt.text=""+selectedDay+"/"+(selectedMonth+1)+"/"+seletedYear;
        }, year,month,day)
        datePickerDialog.show()


    }
}