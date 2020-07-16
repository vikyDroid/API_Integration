package com.vikydroid.demo.learning.dag.d2;

import com.vikydroid.demo.learning.dag.car.engine.DieselEngine;
import com.vikydroid.demo.learning.dag.car.engine.Engine;
import com.vikydroid.demo.learning.dag.car.engine.PetrolEngine;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class DieselEngineModule {
    int horsePower;

    public DieselEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }

    @Provides
    int provideHorsePower() {
        return horsePower;
    }

    //    @Binds
    @Provides
    Engine providesEngine(DieselEngine engine) {
        return engine;
    }

}
