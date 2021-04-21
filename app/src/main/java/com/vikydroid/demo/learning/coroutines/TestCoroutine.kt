package com.vikydroid.demo.learning.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object TestCoroutine {

    @JvmStatic
    fun main(args: Array<String>) {
        val t = System.currentTimeMillis()
        CoroutineScope(Dispatchers.IO).launch {
            val r1 = callSus1()
            val r2 = callSus2(r1)
            val r3 = callSus2(r1)
        }
        println("DEBUG: " + (System.currentTimeMillis() - t))
//        delay(10000)
    }

    private suspend fun callSus2(s: String): String {
        delay(1000)
        println("s2")
        return s + "sdasd"
    }

    private suspend fun callSus1(): String {
        delay(1000)
        println("s1")
        return "asds"
    }
}