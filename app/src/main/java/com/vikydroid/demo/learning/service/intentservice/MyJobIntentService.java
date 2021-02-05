package com.vikydroid.demo.learning.service.intentservice;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;


import static com.vikydroid.demo.utils.UrlsKt.INTENT_DATA;

/*https://www.youtube.com/watch?v=B4gFbWnNpac*/
public class MyJobIntentService extends JobIntentService {
    private static final String TAG = "MyJobIntentService";

    static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, MyJobIntentService.class, 123, work);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    /**
     * Called serially for each work dispatched to and processed by the service.  This
     * method is called on a background thread hence can do long blocking operations
     */
    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Log.d(TAG, "onHandleWork");
        String input = intent.getStringExtra(INTENT_DATA);
        for (int i = 0; i < 10; i++) {
            Log.d(TAG, input + " - " + i);
            if (isStopped())
                return;
            SystemClock.sleep(1000);
        }
    }

    @Override
    public boolean onStopCurrentWork() {
        Log.d(TAG, "onStopCurrentWork");
        return super.onStopCurrentWork();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
