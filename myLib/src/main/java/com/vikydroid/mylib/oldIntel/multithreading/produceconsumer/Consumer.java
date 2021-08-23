package com.vikydroid.mylib.oldIntel.multithreading.produceconsumer;

import java.util.List;

class Consumer implements Runnable {
    List<Integer> sharedListObj;

    Consumer(List<Integer> sharedListObj) {
        this.sharedListObj = sharedListObj;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedListObj) {
                while (sharedListObj.size() < 1) {
                    try {
                        sharedListObj.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                // Getting value from the list
                System.out.println("Getting from queue " + Thread.currentThread().getName() + " " + sharedListObj.get(0));
                // To get out of while(true) loop
                if (sharedListObj.get(0) == 5) break;
                sharedListObj.remove(0);
                sharedListObj.notify();

            }
        }
    }
}