package com.vikydroid.demo.learning.service.broacastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Messenger;

public class SMSBroadcastsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String code = intent.getStringExtra("code");

        Intent intent1 = new Intent("com.an.sms.example");
        intent1.putExtra("code", code);
        context.sendBroadcast(intent1);


        PendingResult pendingResult = goAsync();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //Do long processing
                int i = 0;
                pendingResult.setResultCode(i);
                pendingResult.finish();
            }
        }).start();

//        pendingResult.
    }


}
