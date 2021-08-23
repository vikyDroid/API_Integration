package com.practice.test

fun main() {
    println("dasds")

    val i = 10
    testFun(i)
}

fun testFun(i: Int) {
    when(i){
        1 -> println("1")
        2 -> println("2")
//        3 ->
//        4-> println("2 and 4")
        else -> print("none")
    }

}
