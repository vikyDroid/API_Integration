package com.vikydroid.mylib.oldIntel.oops.inheritance2;

import com.practice.oops.inheritance2.Person;
import com.practice.oops.inheritance2.Student;

import java.util.ArrayList;
import java.util.List;

public class Testttt {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Student());
//        list.add(new Being());
        list.add(new Person());

//        Person person = (Person) new Being();
    }
}
