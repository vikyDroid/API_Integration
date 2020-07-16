package com.vikydroid.demo.learning.multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.vikydroid.demo.R;

import static com.vikydroid.demo.learning.multithreading.MyHandler.TASK_A;
import static com.vikydroid.demo.learning.multithreading.MyHandler.TASK_B;


public class HandlerThreadActivity extends AppCompatActivity {
    MyLooperThread looperThread = new MyLooperThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);
    }

    public void startThread(View view) {
        looperThread.start();
    }

    public void stopThread(View view) {
        looperThread.looper.quit();
    }

    public void taskA(View view) {
        MyHandler handler = new MyHandler(looperThread.looper);
        Message msg = Message.obtain();
        msg.what = TASK_A;
        handler.sendMessage(msg);
    }

    public void taskB(View view) {
        MyHandler handler = new MyHandler(looperThread.looper);
        Message msg = Message.obtain();
        msg.what = TASK_B;
        handler.sendMessage(msg);
    }
}