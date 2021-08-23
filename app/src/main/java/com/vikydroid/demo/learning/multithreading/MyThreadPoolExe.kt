package com.vikydroid.demo.learning.multithreading

import android.os.Handler
import android.os.Looper
import androidx.core.os.HandlerCompat
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

class MyThreadPoolExe {

    companion object {
        val mainThreadHandler: Handler  =  HandlerCompat.createAsync(Looper.getMainLooper())
        @JvmStatic
        fun main(args: Array<String>) {
            main2()

            val ss = ArrayList<String>()
        }

        private fun main2() {
            val executorService = Executors.newFixedThreadPool(5)
            executorService.execute {
                println("I am on background thread")
                executorService.shutdown()
            }
        }
    }


}

