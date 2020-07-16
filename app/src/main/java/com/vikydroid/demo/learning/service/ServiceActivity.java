package com.vikydroid.demo.learning.service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.vikydroid.demo.R;

import static com.vikydroid.demo.utils.UrlsKt.INTENT_DATA;

public class ServiceActivity extends AppCompatActivity {
    private EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        etText = findViewById(R.id.et_text);

    }

    public void startService(View view) {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra(INTENT_DATA, etText.getText().toString().trim());
//        startService(intent);
        ContextCompat.startForegroundService(this, intent);
    }

    public void stopService(View view) {
        stopService(new Intent(this, MyService.class));
    }
}