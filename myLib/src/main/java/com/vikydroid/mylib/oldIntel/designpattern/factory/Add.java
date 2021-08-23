package com.vikydroid.mylib.oldIntel.designpattern.factory;

public class Add implements Calculate{
    @Override
    public void calc(int a, int b) {
        System.out.println("Add is:"+ (a+b));
    }
}
