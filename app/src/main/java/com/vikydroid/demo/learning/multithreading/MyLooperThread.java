package com.vikydroid.demo.learning.multithreading;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

public class MyLooperThread extends Thread {
    private static final String TAG = "MyLooperThread";
//    Handler handler;
    Looper looper;

    @Override
    public void run() {
        Looper.prepare();
        looper = Looper.myLooper();
//        handler = new MyHandler(looper);
        Looper.loop();
        Log.d(TAG, "End of run()");
    }

    void doSom() {
        for (int i = 0; i < 5; i++) {
            Log.d(TAG, "run: " + i);
            SystemClock.sleep(1000);
            Log.d(TAG, "End of run()");
        }
    }
}

