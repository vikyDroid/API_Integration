package com.vikydroid.demo.learning.service.bind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.vikydroid.demo.R;

import org.jetbrains.annotations.NotNull;

public class BinderServiceActivity extends AppCompatActivity {
    private static final String TAG = "BinderServiceActivity";
    private Button btnStartService;
    private BinderServiceVM viewModel;
    private MyBinderService mService;
    private TextView tvProgress;
    private ProgressBar pbServiceProgress;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binder_service);
        viewModel = new ViewModelProvider(this).get(BinderServiceVM.class);

        pbServiceProgress = findViewById(R.id.pb_service_progress);
        btnStartService = findViewById(R.id.btn_start_service);
        tvProgress = findViewById(R.id.tv_progress);

        btnStartService.setOnClickListener(v -> {
            toggleUpdates();
        });

        viewModel.getMyBinder().observe(this, myBinder -> {
            if (myBinder == null) {
                Log.d(TAG, "onCreate: Unbind from service");
            } else {
                Log.d(TAG, "onCreate: bounding to the service");
                mService = myBinder.getService();
                pbServiceProgress.setMax(mService.getMAX_Progress());
            }
        });

        viewModel.getIsProgressBarUpdating().observe(this, aBoolean -> {
            handler = new Handler();
            getRunnable();

            if (aBoolean) {
                btnStartService.setText("Pause");
                handler.postDelayed(runnable, 100);
            } else {
                if (mService.getCURR_Progress() == mService.getMAX_Progress()) {
                    btnStartService.setText("Restart");
                } else {
                    btnStartService.setText("Start");
                }
            }
        });
    }

    @NotNull
     void getRunnable() {
        runnable = () -> {
            if (viewModel.getIsProgressBarUpdating().getValue()) {
                if (viewModel.getMyBinder().getValue() != null) {
                    if (mService.getCURR_Progress() == mService.getMAX_Progress()) {
                        viewModel.setIsProgressBarUpdating(false);
                    }
                    pbServiceProgress.setProgress(mService.getCURR_Progress());
                    int text = 100 * mService.getCURR_Progress() / mService.getMAX_Progress();
                    Log.d(TAG, "Progress: " + text + "%");
                    tvProgress.setText(text + "%");
                }
                handler.postDelayed(this::getRunnable, 100);
            } else {
                handler.removeCallbacks(this::getRunnable);
            }
        };
    }

    private void toggleUpdates() {
        if (mService != null) {
            if (mService.getCURR_Progress() == mService.getMAX_Progress()) {
                mService.resetTask();
                btnStartService.setText("Start");
            } else {
                if (mService.isPaused()) {
                    mService.unPause();
                } else {
                    mService.pauseTask();
                }
                viewModel.setIsProgressBarUpdating(mService.isPaused());
            }
        } else {

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (viewModel.getMyBinder() != null) {
            unbindService(viewModel.getConnection());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        startMyBindService();
//        bindMyBindService();
    }


    private void startMyBindService() {
        Intent intent = new Intent(this, MyBinderService.class);
        startService(intent);

        bindMyBindService();
    }

    private void bindMyBindService() {
        Intent intent = new Intent(this, MyBinderService.class);
        bindService(intent, viewModel.getConnection(), BIND_AUTO_CREATE);
    }
}