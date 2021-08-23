package com.vikydroid.mylib.oldIntel.practice.practice5.multithrading;

public class Odd implements Runnable {
    Data data;

    Odd(Data data) {
        this.data = data;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (data) {
                while (data.i % 2 == 0) {
                    try {
                        data.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Odd : " + data.i++);
                data.notify();
                if (data.i > 10) break;
            }
        }
    }
}
