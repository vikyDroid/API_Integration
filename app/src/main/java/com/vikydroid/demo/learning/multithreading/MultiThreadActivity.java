package com.vikydroid.demo.learning.multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.vikydroid.demo.R;

public class MultiThreadActivity extends AppCompatActivity {
    private static final String TAG = "MultiThreadActivity";
    private Button btnStart, btnStop;
    private volatile boolean stopThread;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_thread);

        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);
        
    }

    public void startThread(View view) {
        stopThread = false;
        MyRunnable myRunnable = new MyRunnable(10);
        new Thread(myRunnable).start();
    }

    public void stopThread(View view) {
        stopThread = true;
    }

    class MyRunnable implements Runnable {
        int seconds;

        MyRunnable(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {
            taskToDo();
        }

        private void taskToDo() {
            for (int i = 0; i < seconds; i++) {
                if (stopThread)
                    return;
                if (i == 5) {
                    Runnable action = () -> btnStart.setText("50%");
//                    Looper.prepare();
//                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(action);
//                    btnStart.post(action);
//                    runOnUiThread(action);
                }
                Log.i(TAG, "run: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}