package com.vikydroid.demo.learning.dag.car;

import android.util.Log;

import com.vikydroid.demo.learning.dag.car.accesories.Remote;
import com.vikydroid.demo.learning.dag.car.accesories.Wheels;
import com.vikydroid.demo.learning.dag.car.engine.Engine;
import com.vikydroid.demo.learning.dag.d2.ActivityScope;

import javax.inject.Inject;

@ActivityScope
public class Car {
    private static final String TAG = "Car";
    private Driver driver;
    private Engine engine;
    private Wheels wheels;

    @Inject
    public Car(Driver driver, Engine engine, Wheels wheels) {
        this.driver = driver;
        this.engine = engine;
        this.wheels = wheels;
    }

    @Inject
    void enableRemote(Remote listener) {
        listener.setListener(this);
    }

    public void start() {
        engine.start();
        Log.d(TAG, driver + " " + driver.name + " Driving " + this);
    }
}
