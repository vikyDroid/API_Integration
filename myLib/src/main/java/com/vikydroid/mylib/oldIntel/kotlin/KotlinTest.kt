package com.practice.kotlin

object KotlinTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val numbers = mutableListOf("One", "Two", "Three", "Four", "Five")
        numbers.map {
            it.length
        }.filter {
            it > 3
        }.let {
            print(it)
        }
    }
}