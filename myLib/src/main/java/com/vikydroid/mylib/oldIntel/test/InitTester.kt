package com.practice.test

import kotlin.concurrent.thread

class InitTester(age: Int) {

    constructor(age: Double, ageee: Int) : this(ageee) {
        this._age = age
    }

    private var _age: Double? = null
    private var name = ""

    constructor(name: String, age: Int) : this(age) {
        this.name = name
    }

    var count = 1;

    init {
        println("$count age: $age and name: $name")
        count++
    }


    fun main(){
        thread(isDaemon = false) {

        }
    }
}