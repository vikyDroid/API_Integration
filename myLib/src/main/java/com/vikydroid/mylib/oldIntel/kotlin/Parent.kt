package com.practice.kotlin

open class Parent  constructor(i: Int) {

    companion object {
        init {
            println("parent static init 1")
        }

        init {
            println("parent static init 2")
        }

        init {
            println("parent static init 3")
        }
    }

    init {
        println("parent init 1")
    }

    init {
        println("parent init 2")
    }

    init {
        println("parent init 3========$i")
    }

}