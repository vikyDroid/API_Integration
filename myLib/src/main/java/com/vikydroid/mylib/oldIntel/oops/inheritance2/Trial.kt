package com.practice.oops.inheritance2

class Trial {
    val list: ArrayList<Person> = arrayListOf()

    init {
        list.add(Person())
//        list.add(Being())
        list.add(Student())
    }
}