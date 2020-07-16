package com.vikydroid.demo.learning.dag.d2;

import com.vikydroid.demo.learning.dag.car.accesories.Rim;
import com.vikydroid.demo.learning.dag.car.accesories.Tyre;
import com.vikydroid.demo.learning.dag.car.accesories.Wheels;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class WheelModule {

    @Provides
    static Wheels getWheels(Rim rim, Tyre tyre) {
        return new Wheels(rim, tyre);
    }

    @Provides
    static Rim getRim() {
        return new Rim();
    }

    @Provides
    static Tyre getTyre() {
        Tyre tyre = new Tyre();
        tyre.inflate();
        return tyre;
    }

}
