package com.vikydroid.demo.learning.service.broacastreceiver.localbr;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.util.Date;

public class MyIS extends IntentService {
    public static final String CUSTOM_ACTION = "YOUR_CUSTOM_ACTION";

    public MyIS(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent arg0) {
        Intent intent = new Intent(CUSTOM_ACTION);
        intent.putExtra("DATE", new Date().toString());

        // send local broadcast
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
