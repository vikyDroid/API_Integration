package com.vikydroid.demo.learning.jobscheduler;

import android.annotation.SuppressLint;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.RequiresApi;

@SuppressLint("SpecifyJobSchedulerIdRange")
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MyJobService extends JobService {
    private static final String TAG = "MyJobService";
    private boolean stopService;

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d(TAG, "Job started");
        doSomethingBG(params);
        return true;
    }

    private void doSomethingBG(JobParameters params) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Log.d(TAG, "run: " + i);
                if (stopService)
                    return;
                SystemClock.sleep(1000);
            }
            Log.d(TAG, "Job Finished");
            jobFinished(params, false);
        }).start();
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        stopService = true;
        Log.d(TAG, "Job cancelled before completion");
        return true;
    }

}
