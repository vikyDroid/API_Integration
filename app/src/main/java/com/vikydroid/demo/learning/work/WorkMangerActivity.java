package com.vikydroid.demo.learning.work;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.vikydroid.demo.R;

import java.util.concurrent.TimeUnit;

import static com.vikydroid.demo.learning.work.MyWorker.TASK_DESC;

public class WorkMangerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manger);

        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(false)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiredNetworkType(NetworkType.UNMETERED)
                .build();

        Data data = new Data.Builder()
                .putString(TASK_DESC, "The task data has been passed from activity")
                .build();

        final OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(MyWorker.class)
                .setInputData(data)
                .setConstraints(constraints)
                .build();

        findViewById(R.id.btn_start_work).setOnClickListener(v -> {
            WorkManager.getInstance(this).enqueue(oneTimeWorkRequest);
        });

        TextView textView = findViewById(R.id.tv_work_status);
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneTimeWorkRequest.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        textView.append(workInfo.getOutputData().getString(TASK_DESC) + "\n");
                        textView.append(String.format("%s\n", workInfo.getState().name()));
                    }
                });

        final PeriodicWorkRequest periodicWorkRequest
                = new PeriodicWorkRequest.Builder(MyWorker.class, 10, TimeUnit.HOURS)
                .build();
        //Chaninig
        WorkManager.getInstance(this).
                beginWith(oneTimeWorkRequest)
                .then(oneTimeWorkRequest)
                .then(oneTimeWorkRequest)
                .enqueue();

    }
}