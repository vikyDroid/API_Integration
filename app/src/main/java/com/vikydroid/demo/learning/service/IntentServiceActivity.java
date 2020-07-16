package com.vikydroid.demo.learning.service;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.vikydroid.demo.R;

import static com.vikydroid.demo.utils.UrlsKt.INTENT_DATA;

public class IntentServiceActivity extends AppCompatActivity {
    private EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        etText = findViewById(R.id.et_text);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStateNotSaved() {
        super.onStateNotSaved();
    }

    public void startService(View view) {
        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra(INTENT_DATA, etText.getText().toString().trim());
        ContextCompat.startForegroundService(this, intent);
    }

    public void enqueueService(View view) {
        Intent intent = new Intent(this, MyJobIntentService.class);
        intent.putExtra(INTENT_DATA, etText.getText().toString().trim());
        MyJobIntentService.enqueueWork(this, intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}