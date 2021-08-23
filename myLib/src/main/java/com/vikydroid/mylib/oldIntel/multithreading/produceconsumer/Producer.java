package com.vikydroid.mylib.oldIntel.multithreading.produceconsumer;

import java.util.List;

class Producer implements Runnable {
    List<Integer> sharedListObj;

    Producer(List<Integer> sharedListObj) {
        this.sharedListObj = sharedListObj;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            synchronized (sharedListObj) {
                // While condition as mandated to avoid spurious wakeup
                while (sharedListObj.size() >= 1) {
                    try {
                        sharedListObj.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                // Putting value in the list
                System.out.println("Adding to queue - " + Thread.currentThread().getName() + " " + ++i);
                sharedListObj.add(i);
                sharedListObj.notify();
                // To get out of while(true) loop, putting
                // only 5 values
                if (i > 4) break;
            }
        }
    }
}