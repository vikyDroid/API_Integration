package com.vikydroid.demo.learning.multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import com.vikydroid.demo.R;

public class HandlerThreadDefaultActivity extends AppCompatActivity {
    private static final String TAG = "HandlerThreadDefaultAct";
    private HandlerThread handlerThread = new HandlerThread("HandlerThreadDefault");
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread_default);

        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
    }

    public void doWork(View view) {
        handler.post(new MyRunnable1());
        handler.post(new MyRunnable2());
    }

    public void removeMessage(View view) {
    }

    static class MyRunnable1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                Log.d(TAG, "Runnable1 :" + i);
                SystemClock.sleep(1000);
            }
        }
    }

    static class MyRunnable2 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                Log.d(TAG, "Runnable2 :" + i);
                SystemClock.sleep(1000);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handlerThread.quit();
    }
}