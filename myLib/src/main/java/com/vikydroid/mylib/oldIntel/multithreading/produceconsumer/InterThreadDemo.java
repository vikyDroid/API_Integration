package com.vikydroid.mylib.oldIntel.multithreading.produceconsumer;

import java.util.ArrayList;
import java.util.List;

public class InterThreadDemo {
    public static void main(String[] args) {
        // This is the shared list shared between producer
        // and consumer
        List<Integer> sharedListObj = new ArrayList<Integer>();
        Thread t1 = new Thread(new Producer(sharedListObj), "Producer");
        Thread t2 = new Thread(new Consumer(sharedListObj), "Consumer");
        t1.start();
        t2.start();
    }

}