package com.vikydroid.demo.learning.dag.d2;

import com.vikydroid.demo.learning.dag.DagActivity;
import com.vikydroid.demo.learning.dag.car.Car;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {WheelModule.class, PetrolEngineModule.class})
public interface ActivityComponent {

    void inject(DagActivity activity);

    Car getCar();

    /*@Subcomponent.Builder
    interface Builder {

        @BindsInstance
        Builder horsePower(@Named("hp") int horsePower);

        @BindsInstance
        Builder engineCapacity(@Named("ec") int engineCapacity);

        ActivityComponent build();
    }*/

    @Subcomponent.Factory
    interface Factory {

        ActivityComponent create(@BindsInstance @Named("hp") int horsePower,
                                 @BindsInstance @Named("ec") int engineCapacity);
    }

}
