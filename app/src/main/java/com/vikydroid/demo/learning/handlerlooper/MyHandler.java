package com.vikydroid.demo.learning.handlerlooper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class MyHandler extends Handler {
    private static final String TAG = "MyHandler";
    public static final int TASK_A = 1;
    public static final int TASK_B = 2;

    MyHandler(Looper looper){
        super(looper);
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        switch (msg.what) {
            case TASK_A:
                Log.d(TAG, "handleMessage: Task A executed");
                break;
            case TASK_B:
                Log.d(TAG, "handleMessage: Task B executed");
                break;
            default:
                Log.d(TAG, "handleMessage: default case of switch");
        }
    }
}
