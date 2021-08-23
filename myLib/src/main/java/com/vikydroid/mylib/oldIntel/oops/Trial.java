package com.vikydroid.mylib.oldIntel.oops;

import com.practice.oops.MyInterface;

public class Trial {

    static Trial create(MyInterface myInterface) {
//        myInterface.call(new Subscriber());
        return new Trial();
    }
}
