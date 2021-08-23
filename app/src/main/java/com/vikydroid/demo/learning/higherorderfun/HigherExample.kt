package com.vikydroid.demo.learning.higherorderfun

class HigherExample {

    companion object {

        @JvmStatic
        fun main(arg: Array<String>) {
            myTest1("g", {
                println(it)
            }, {
                println(it)
            })
        }

        private fun myTest1(
            s: String,
            callback: (String) -> Unit,
            callbackError: (Int) -> Unit
        ) {
            if (s.isBlank())
                callback("error")
            else
                callback("success")

            callbackError(440)
        }
    }
}