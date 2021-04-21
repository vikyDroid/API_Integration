package com.vikydroid.demo.learning2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.vikydroid.demo.R

class MyServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_service)
    }

    fun startService(view: View) {
        val intent = Intent(this@MyServiceActivity, MyService::class.java)
        startService(intent)
//        ContextCompat.startForegroundService(this@MyServiceActivity, intent)
    }
}