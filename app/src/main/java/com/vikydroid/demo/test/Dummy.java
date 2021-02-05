package com.vikydroid.demo.test;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;

import com.vikydroid.demo.learning.service.broacastreceiver.SMSBroadcastsReceiver;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Dummy {
    public static void main(String[] args) {
//        Executors executors = new Executors();
//        executors.newFixedThreadPool(10);
        SMSBroadcastsReceiver receiver = new SMSBroadcastsReceiver();
        BroadcastReceiver.PendingResult ff= receiver.goAsync();


    }


}
