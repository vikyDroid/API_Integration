package com.vikydroid.demo.learning.service.broacastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.vikydroid.demo.R;

public class BRActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_r);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String code = intent.getStringExtra("code");
            }
        };
        registerReceiver(broadcastReceiver, new IntentFilter("com.an.sms.example"));
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }
}