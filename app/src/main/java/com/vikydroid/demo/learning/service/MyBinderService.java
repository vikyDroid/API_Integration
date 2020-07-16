package com.vikydroid.demo.learning.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyBinderService extends Service {
    private static final String TAG = "MyBinderService";
    private MyBinder myBinder = new MyBinder();

    public boolean isPaused() {
        return isPaused;
    }

    public int getMAX_PRO() {
        return MAX_PRO;
    }

    public int getCURR_PRO() {
        return CURR_PRO;
    }

    private boolean isPaused;
    private int MAX_PRO, CURR_PRO;
    private Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();
        isPaused = true;
        MAX_PRO = 5000;
        CURR_PRO = 0;
        handler = new Handler();
        Log.d(TAG, "onCreate: Service created");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public class MyBinder extends Binder {
        MyBinderService getService() {
            return MyBinderService.this;
        }
    }

    void unPause() {
        isPaused = false;
        startTask();
    }

    void startTask() {
        final Runnable runnable = () -> {
            if (isPaused || CURR_PRO >= MAX_PRO) {
                Log.d(TAG, "startTask: Removing Callbacks");
                handler.removeCallbacks(this::startTask);
            } else {
                Log.d(TAG, "run: Progress: " + CURR_PRO);
                CURR_PRO += 100;
                handler.postDelayed(this::startTask, 100);
            }
        };
        handler.postDelayed(runnable, 100);
    }

    void pauseTask() {
        isPaused = true;
        Log.d(TAG, "pauseTask: ");
    }

    void resetTask() {
        CURR_PRO = 0;
        Log.d(TAG, "resetTask: ");
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        Log.d(TAG, "onTaskRemoved: ");
        stopSelf();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
