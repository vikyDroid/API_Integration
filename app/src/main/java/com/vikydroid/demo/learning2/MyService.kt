package com.vikydroid.demo.learning2

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.delay

class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.e(Companion.TAG, "onCreate: ")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        return super.onStartCommand(intent, flags, startId)
        Log.e(TAG, "onStartCommand: ")
        Thread.sleep(2000)
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.e(TAG, "onBind: ")
        return null
    }

    companion object {
        private const val TAG = "MyService"
    }
}