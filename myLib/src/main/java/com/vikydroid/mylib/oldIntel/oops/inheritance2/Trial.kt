package com.vikydroid.mylib.oldIntel.oops.inheritance2

import com.practice.oops.inheritance2.Person
import com.practice.oops.inheritance2.Student

class Trial {
    val list: ArrayList<Person> = arrayListOf()

    init {
        list.add(Person())
//        list.add(Being())
        list.add(Student())
    }
}