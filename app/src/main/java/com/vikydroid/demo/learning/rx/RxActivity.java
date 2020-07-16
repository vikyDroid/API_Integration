package com.vikydroid.demo.learning.rx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.vikydroid.demo.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlinx.coroutines.flow.Flow;

public class RxActivity extends AppCompatActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);

        /*Observable<Task> taskObservable = Observable
                .just()*/
    }
}