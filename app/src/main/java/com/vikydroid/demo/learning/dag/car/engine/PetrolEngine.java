package com.vikydroid.demo.learning.dag.car.engine;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class PetrolEngine implements Engine {
    private static final String TAG = "PetrolEngine";
    private int horsePower;
    private int engineCapacity;

    @Inject
    public PetrolEngine(@Named("hp") int horsePower,
                        @Named("ec") int engineCapacity) {
        this.horsePower = horsePower;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void start() {
        Log.d(TAG, "Petrol engine started. Horsepower : " + horsePower);
        Log.d(TAG, "Petrol engine started. EngineCapacity : " + engineCapacity);
    }
}
