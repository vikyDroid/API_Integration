package com.vikydroid.demo.learning.multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vikydroid.demo.R;

import java.lang.ref.WeakReference;

/**
 * Async with {@link WeakReference}
 */
public class AsyncWithWRActivity extends AppCompatActivity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_with_w_r);
        progressBar = findViewById(R.id.pb_progress);
    }

    public void startAsync(View view) {
        MyAsyncTask asyncTask = new MyAsyncTask(this);
        asyncTask.execute(10);
    }

    static class MyAsyncTask extends AsyncTask<Integer, Integer, String> {
        private WeakReference<AsyncWithWRActivity> activityWeakReference;

        MyAsyncTask(AsyncWithWRActivity activity) {
            activityWeakReference = new WeakReference<>(activity);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            AsyncWithWRActivity activity = activityWeakReference.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            activity.progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            for (int i = 0; i < integers[0]; i++) {
                publishProgress((i * 100) / integers[0]);
                SystemClock.sleep(1000);
            }
            return "Finished!";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            AsyncWithWRActivity activity = activityWeakReference.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            activity.progressBar.setProgress(0);
            activity.progressBar.setVisibility(View.GONE);
            Toast.makeText(activity, s, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            AsyncWithWRActivity activity = activityWeakReference.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            activity.progressBar.setProgress(values[0]);
        }
    }
}