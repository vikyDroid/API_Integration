package com.vikydroid.mylib.oldIntel.practice.practice5.multithrading;

public class Even implements Runnable {
    Data data;

    Even(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (data) {
                while (data.i % 2 != 0) {
                    try {
                        data.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Even : " + data.i++);
                data.notify();
                if (data.i > 10) break;
            }
        }
    }
}
