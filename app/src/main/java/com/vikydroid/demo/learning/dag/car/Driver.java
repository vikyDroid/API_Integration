package com.vikydroid.demo.learning.dag.car;

import javax.inject.Inject;
import javax.inject.Singleton;

//@Singleton
public class Driver {
    //we can't change this class as we do not own this
    String name;

    public Driver(String name) {
        this.name = name;
    }
}
