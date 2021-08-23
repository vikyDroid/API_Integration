package com.practice.kotlin

class Dummy {
    companion object {
        init {
            println("Dummy.static initializer 1")
        }

        init {
            println("Dummy.static initializer 2")
        }

        init {
            println("Dummy.static initializer 3")
        }
    }

    init {
        println("Dummy.instance initializer 1")
    }

    init {
        println("Dummy.instance initializer 2")
    }
}