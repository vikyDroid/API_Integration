package com.vikydroid.demo.learning.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.vikydroid.demo.R;

import static com.vikydroid.demo.utils.UrlsKt.CHANNEL_ID;

public class MyService extends Service {
    private static final String TAG = "MyService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input = intent.getStringExtra("data");

        Intent intent1 = new Intent(this, ServiceActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent1, 0);

        Notification notification = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this, CHANNEL_ID)
                    .setContentIntent(pendingIntent)
                    .setContentText(input)
                    .setContentTitle(this.getString(R.string.app_name))
                    .setSmallIcon(R.drawable.ic_android)
                    .build();

            startForeground(1, notification);
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
