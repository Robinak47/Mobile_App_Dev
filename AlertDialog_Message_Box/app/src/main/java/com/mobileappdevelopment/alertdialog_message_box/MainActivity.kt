package com.mobileappdevelopment.alertdialog_message_box

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn=findViewById(R.id.btn)

        btn.setOnClickListener {
            showAlertDialogMessage()
        }
    }


    fun showAlertDialogMessage()
    {
        var alertDialog=AlertDialog.Builder(this)

        alertDialog.setTitle("Caution")
            .setMessage("Do you really want to change the text of the button")
            .setIcon(R.drawable.caution)
            .setCancelable(false)
            .setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->

                dialogInterface.cancel()
            }


            )
            .setPositiveButton("yes", DialogInterface.OnClickListener { dialogInterface, i ->
                btn.text="Dont Click Me"
            })
            alertDialog.show()
    }
}