package com.vikydroid.demo.learning.multithreading;

import android.content.Intent;
import android.os.HandlerThread;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MyHandlerThread extends HandlerThread {
    public MyHandlerThread(String name) {
        super(name);
    }

    void doSome() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("asdsdad");
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("fdlgjlkdjklf");
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("sddasf");
            }
        });

        //Getting num of cores/processors, gives 4 for quad core
        int numOfCores = Runtime.getRuntime().availableProcessors();
    }

}
