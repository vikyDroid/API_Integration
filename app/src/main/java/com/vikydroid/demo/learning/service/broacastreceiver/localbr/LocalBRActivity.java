package com.vikydroid.demo.learning.service.broacastreceiver.localbr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class LocalBRActivity extends AppCompatActivity {
    private static final String TAG = "LocalBRActivity";

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String date = intent.getStringExtra("DATE");
            Log.d(TAG, "onReceive: "+date);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(MyIS.CUSTOM_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, filter);
    }
}
