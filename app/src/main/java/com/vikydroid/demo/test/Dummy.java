package com.vikydroid.demo.test;

import android.content.BroadcastReceiver;

import com.vikydroid.demo.learning.service.broacastreceiver.SMSBroadcastsReceiver;

public class Dummy {
    public static void main(String[] args) {
//        Executors executors = new Executors();
//        executors.newFixedThreadPool(10);
        SMSBroadcastsReceiver receiver = new SMSBroadcastsReceiver();
        BroadcastReceiver.PendingResult ff = receiver.goAsync();

        System.out.println(MyObject.INSTANCE.getInt());

    }


}
