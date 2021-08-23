package com.vikydroid.mylib.oldIntel.multithreading.locking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Store {
    Semaphore semaphore = new Semaphore(23);
    private final MyCallBack callBack;
    private final ExecutorService executor = Executors.newFixedThreadPool(2);
    private final List<Item> items = Arrays.asList(new Item("Towel", 100),
            new Item("henky", 10),
            new Item("pen drive", 300));

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public Store(MyCallBack callBack) {
        this.callBack = callBack;
    }

    void syncPrices() {
        Lock writeLock = readWriteLock.writeLock();
        executor.execute(() -> {
            writeLock.lock();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (Item item : items) {
                item.setPrice(500);
            }
            System.out.println("Prices Hiked");
            callBack.syncing();
            writeLock.unlock();
        });
    }

    void createInvoice() {
        Lock lock = readWriteLock.readLock();
        executor.execute(() -> {
            lock.lock();
            System.out.println("Total amount: " + getTotal());
            callBack.createInvoice();
            lock.unlock();
        });
    }

    private int getTotal() {
        int sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

}
