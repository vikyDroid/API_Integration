package com.vikydroid.demo.learning2.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class MyService : Service() {
    private val TAG = MyService::class.java.simpleName
    private var count = 1

    override fun onCreate() {
        super.onCreate()
        val s = "Service Started"
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
        println("$TAG : $s")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("$TAG onStartCommand")
        Thread {
            for (i in 1..10) {
                Thread.sleep(1000)
                println("${Thread.currentThread().name} and count : $count")
                //Toast.makeText(this, "service", Toast.LENGTH_SHORT).show()
                count++
            }
        }.start()

        return START_REDELIVER_INTENT
//        return super.onStartCommand(intent, flags, startId)

    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        println("$TAG : Service destroyed")
    }
}