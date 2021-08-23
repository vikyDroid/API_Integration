package com.vikydroid.mylib.oldIntel.interviews.times.design.vas;

import com.vikydroid.mylib.oldIntel.interviews.times.design.cakes.Cake;

public class CreamVAS extends VAS {

    public CreamVAS(Cake cake) {
        super(cake);
    }

    @Override
    int getCost() {
        return cake.getCost() + 100;
    }

    @Override
    String getDesc(String s) {
        return s + ", Cream added";
    }
}
