package com.vikydroid.mylib.oldIntel.designpattern.factory;

public class Division implements Calculate {
    @Override
    public void calc(int a, int b) {
        System.out.println("Division is:" + (a / b));
    }
}
