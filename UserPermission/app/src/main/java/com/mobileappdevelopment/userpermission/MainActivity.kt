package com.mobileappdevelopment.userpermission

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var SEND_SMS_CODE=101
    lateinit var num: EditText
    lateinit var msg: EditText
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

        num=findViewById<EditText>(R.id.num)
        msg=findViewById<EditText>(R.id.msg)
        btn=findViewById<Button>(R.id.btn)

        var phoneNo:String=num.text.toString()
        var message=msg.text.toString()

        btn.setOnClickListener {
            var phoneNo:String=num.text.toString()
            var message=msg.text.toString()

            if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED)
            {
                sendSMS(phoneNo,message)
            }

            else{

                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS), SEND_SMS_CODE)
            }
        }




    }

    fun sendSMS(phoneNumber:String, msgg:String)
    {

        var smsManager: SmsManager

        if(Build.VERSION.SDK_INT>=23)
        {
            smsManager=this.getSystemService(SmsManager::class.java)


        }

        else
        {
            smsManager= SmsManager.getDefault()
        }

        smsManager.sendTextMessage(phoneNumber,null,msgg,null,null)
        Toast.makeText(this, "Sms Sent", Toast.LENGTH_SHORT).show()


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==SEND_SMS_CODE)
        {
            if(grantResults.isNotEmpty()&& grantResults[0]== PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
            }

        }

        else
        {

        }
    }
}