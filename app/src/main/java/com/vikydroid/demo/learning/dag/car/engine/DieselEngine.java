package com.vikydroid.demo.learning.dag.car.engine;

import android.util.Log;

import javax.inject.Inject;

public class DieselEngine implements Engine {
    private static final String TAG = "DieselEngine";
    int horsePower;

    @Inject
    DieselEngine(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public void start() {
        Log.d(TAG, "Diesel engine started. horsepower: " + horsePower);
    }
}
