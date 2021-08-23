package com.vikydroid.mylib.oldIntel.multithreading.evenodd;

public class Odd implements Runnable {
    Pojo pojo;

    Odd(Pojo pojo) {
        this.pojo = pojo;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (pojo) {
                while (pojo.i % 2 == 0) { // To avoid spurious wakeup, when num is even, wait
                    try {
                        pojo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //prints odd but produces even
                System.out.println("Odd : " + pojo.i++);
                pojo.notify();
                if (pojo.i > 10) break;
            }
        }
    }
}
