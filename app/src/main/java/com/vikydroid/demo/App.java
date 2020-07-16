package com.vikydroid.demo;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import com.vikydroid.demo.learning.dag.d2.AppComponent;
import com.vikydroid.demo.learning.dag.d2.DaggerAppComponent;
import com.vikydroid.demo.learning.dag.d2.DriverModule;

import static com.vikydroid.demo.utils.UrlsKt.CHANNEL_ID;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.factory().create(new DriverModule("VikyDroid"));
        createNotificationChannel();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(
                        CHANNEL_ID,
                        "Channel 1",
                        NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(channel);
            }
        }
    }
}
