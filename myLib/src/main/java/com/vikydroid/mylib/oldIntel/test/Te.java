package com.vikydroid.mylib.oldIntel.test;

public class Te implements B, A {


    public static void main(String[] args) {
        A a = new Te();
        a.test();
        int num = 10;
        num = -num;
        System.out.println(num);

    }

    @Override
    public void test() {
        System.out.println("Te");
    }
}
