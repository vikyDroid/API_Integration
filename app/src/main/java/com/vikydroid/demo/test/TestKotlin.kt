package com.vikydroid.demo.test

fun main() {

    val node = Node()
    node.also {
        it.a = 111
    }
    println(node.a)
}

class Node {
   var a = 10
}