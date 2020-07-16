package com.vikydroid.demo.learning.dag.d2;

import com.vikydroid.demo.learning.dag.car.engine.Engine;
import com.vikydroid.demo.learning.dag.car.engine.PetrolEngine;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class PetrolEngineModule {
    /*int horsePower;

    public PetrolEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }*/

    @Binds
    abstract Engine providesEngine(PetrolEngine engine);

}
