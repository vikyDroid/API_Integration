package com.vikydroid.mylib.oldIntel.practice.practice1.arrays;

public class MyClass {
    String val;

    MyClass(String val) {
        this.val = val;
    }




    public static void main(String[] args) {
        MyClass[] myObjectArray = new MyClass[3];

        for (int i = 0; i <= 2; i++) {

            myObjectArray[i] = new MyClass("NO :"+i);

        }
    }


}
