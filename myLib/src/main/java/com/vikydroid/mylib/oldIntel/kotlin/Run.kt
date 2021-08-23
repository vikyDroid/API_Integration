package com.practice.kotlin

import java.util.*
import java.util.function.Function

fun main() {
//    Child()
    println("Main starts")
//    higherfunc("ABC", "sdasd", ::println, ::println)

    lambdas({
        println("lamdaaaa 1")
//        return
    }, {
        println("Lambdaaaa 2")
//        return
    })
    println("Main ends")

    genericFun<Int>()

    println(flag)

    var k = Unit
    println(k)

}

inline fun higherFunc(str: String, vv: String, myCall: (String) -> Unit, mmCal: (Int) -> Unit) {
    //inovkes the print() by passing the string str
    myCall("Vivelk")
    mmCal(2)
}

var lam1 = {
    println("lambda exp")
}
var lam2 = {
    println("lambda exp")
}

inline fun lambdas(crossinline lambda1: () -> Unit, lambda2: () -> Unit) {
    lambda1()
    lambda2()
}

inline fun <reified T> genericFun() {
    println(T::class)
}

inline var flag: Boolean
    get() = foo(10) == 100
    set(value) {
        value
    }

fun foo(i: Int): Int {
    return i
}

fun dummy() {
//    arrayListOf<String>().filter { }

    /*Function<String, Int> {

    }
    kotlin.jvm.functions.Function1<String, String>*/

    //This way we use inner classes in kotlin
    val value = object : Human {
        override fun think() {

        }
    }
    var dummy: Human = value
}

val tt: (Int) -> Unit = { s: Int -> println(s) }

interface Human {
    fun think()
}

