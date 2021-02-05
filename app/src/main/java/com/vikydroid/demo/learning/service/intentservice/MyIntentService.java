package com.vikydroid.demo.learning.service.intentservice;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;

import com.vikydroid.demo.App;
import com.vikydroid.demo.R;

import static com.vikydroid.demo.utils.UrlsKt.CHANNEL_ID;
import static com.vikydroid.demo.utils.UrlsKt.INTENT_DATA;

public class MyIntentService extends IntentService {
    private static final String TAG = "MyIntentService";
    private PowerManager.WakeLock wakeLock;

    public MyIntentService() {
        super(TAG);
        setIntentRedelivery(false);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");

        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "DemoApp:MyWakeLock");
        wakeLock.acquire( 10 * 60 * 1000L /*10 minutes*/);
        Log.d(TAG, "WakeLock Acquired");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification notification = new Notification.Builder(this, CHANNEL_ID)
                    .setContentTitle("Example IS")
                    .setContentText("Running...")
                    .setSmallIcon(R.drawable.ic_android)
                    .build();

            startForeground(1, notification);
        }
    }

    /**
     * This method is called on a background thread hence can do long blocking operations
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String data = intent.getStringExtra(INTENT_DATA);
        Log.d(TAG, "onHandleIntent");

        for (int i = 0; i < 10; i++) {
            Log.d(TAG, data + " - " + i);
            SystemClock.sleep(1000);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
