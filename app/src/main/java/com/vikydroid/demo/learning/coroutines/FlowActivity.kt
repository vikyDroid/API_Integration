package com.vikydroid.demo.learning.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vikydroid.demo.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FlowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)

        CoroutineScope(IO).launch {
            println("debug: Stream Start")
            getPrimeNum().collect {
                println("debug: Num is $it")
            }
            println("debug: Stream End")
        }
    }

    private fun getPrimeNum() = flow {
        val primeList = listOf(1, 3, 5, 6, 7, 8, 9)
        primeList.forEach {
            delay(it * 100L)
            println("debug: Thread is ${Thread.currentThread().name}")
            emit(it)
        }
    }
}