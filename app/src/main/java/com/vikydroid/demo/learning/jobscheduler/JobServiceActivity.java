package com.vikydroid.demo.learning.jobscheduler;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.vikydroid.demo.R;

public class JobServiceActivity extends AppCompatActivity {
    private static final String TAG = "JobServiceActivity";
    private int jobId = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_service);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void scheduleJob(View view) {
        ComponentName componentName = new ComponentName(this, MyJobService.class);
        JobInfo jobInfo = new JobInfo.Builder(jobId, componentName)
                .setPeriodic(1000 * 60 * 15)
                .setPersisted(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
//                .setRequiresCharging(true)
                .build();

        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        int resultCode = jobScheduler.schedule(jobInfo);
        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.d(TAG, "Job scheduled");
        } else {
            Log.d(TAG, "Job scheduling failed");
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void cancelJob(View view) {
        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        scheduler.cancel(jobId);
        Log.d(TAG, "Job cancelled");
    }
}