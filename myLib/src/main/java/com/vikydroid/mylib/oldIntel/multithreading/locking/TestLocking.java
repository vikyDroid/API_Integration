package com.vikydroid.mylib.oldIntel.multithreading.locking;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * In Progress, hence code is broken
 */
public class TestLocking {
    public static void main(String[] args) {
        AtomicBoolean syncing = new AtomicBoolean(true);
        AtomicBoolean invoicing = new AtomicBoolean(true);

        Store store = new Store(new MyCallBack() {
            @Override
            public void syncing() {
                syncing.set(false);
            }

            @Override
            public void createInvoice() {
                invoicing.set(false);
            }
        });

//        store.syncPrices();
        store.createInvoice();
        store.syncPrices();


        while (syncing.get() || invoicing.get()) {
//            System.out.println("Running");
        }

        System.out.println("Termination");
    }
}
