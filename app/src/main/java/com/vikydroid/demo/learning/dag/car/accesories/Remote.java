package com.vikydroid.demo.learning.dag.car.accesories;

import android.util.Log;

import com.vikydroid.demo.learning.dag.car.Car;

import javax.inject.Inject;

public class Remote {
    private static final String TAG = "Remote";

    @Inject
    Remote() {
    }

    public void setListener(Car car) {
        Log.d(TAG, "Remote connected with: "+car.toString());
    }
}
