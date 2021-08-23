package com.vikydroid.mylib.oldIntel.practice.practice5.multithrading;

public class EvenOddTester {
    public static void main(String[] args) {
        Data data = new Data(0);
        Thread t1 =new Thread(new Even(data));
        Thread t2 =new Thread(new Odd(data));
        t1.start();
        t2.start();
    }
}
