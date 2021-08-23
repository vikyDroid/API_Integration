package com.vikydroid.mylib.oldIntel.multithreading.evenodd;

public class Even implements Runnable, Thread.UncaughtExceptionHandler {
    final Pojo pojo;

    Even(Pojo pojo) {
        this.pojo = pojo;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (pojo) {
                while (pojo.i % 2 != 0) {//o avoid spurious wakeup, when num is odd, wait
                    try {
                        pojo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //Prints even but produces odd
                System.out.println("Even : " + pojo.i++);
                pojo.notify();
                if (pojo.i > 10) break;
            }
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(e.toString());
    }
}
