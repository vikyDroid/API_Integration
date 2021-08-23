package com.practice.kotlin

class Child (private var age: Int) : Parent(age) {

//    constructor(name: String, age: Int): super(age)

    val ageNum: Int? = age

    companion object {
        init {
            println("child static init 1")
        }

        init {
            println("child static init 2")
        }

        init {
            println("child static init 3")
        }
    }

    init {
        println("child init 1")
    }

    init {
        println("child init 2")
    }

    init {
        println("child init 3")
    }
}

