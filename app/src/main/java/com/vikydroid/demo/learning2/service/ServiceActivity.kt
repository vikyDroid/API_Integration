package com.vikydroid.demo.learning2.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.vikydroid.demo.R
import kotlinx.android.synthetic.main.activity_service2.*

class ServiceActivity : AppCompatActivity() {
    private lateinit var serviceIntent: Intent
    private val TAG = ServiceActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service2)
        println("$TAG : OnCreate")
        bt_start_service.setOnClickListener {
//            println("$TAG : Start Service Clicked")
            serviceIntent = Intent(this, MyService::class.java)
            startService(serviceIntent)
        }

        bt_stop_service.setOnClickListener {
            stopService(serviceIntent)
        }
    }
}