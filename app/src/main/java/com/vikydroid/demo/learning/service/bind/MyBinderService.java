package com.vikydroid.demo.learning.service.bind;

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
    private boolean isPaused;
    private int MAX_Progress, CURR_Progress;
    private Handler handler;

    public boolean isPaused() {
        return isPaused;
    }

    public int getMAX_Progress() {
        return MAX_Progress;
    }

    public int getCURR_Progress() {
        return CURR_Progress;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        isPaused = true;
        MAX_Progress = 5000;
        CURR_Progress = 0;
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
            if (isPaused || CURR_Progress >= MAX_Progress) {
                Log.d(TAG, "startTask: Removing Callbacks");
                handler.removeCallbacks(this::startTask);
            } else {
                Log.d(TAG, "run: Progress: " + CURR_Progress);
                CURR_Progress += 100;
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
        CURR_Progress = 0;
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
