package com.vikydroid.demo.learning.dag.d2;

import com.vikydroid.demo.learning.dag.car.Driver;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DriverModule {
    String driverName;

    @Inject
    public DriverModule(String driverName) {
        this.driverName = driverName;
    }

    @Singleton
    @Provides
    Driver provideDriver() {
        return new Driver(driverName);
    }

    public static void main(String[] args) {
        char c = Character.toLowerCase('c');
    }
}
