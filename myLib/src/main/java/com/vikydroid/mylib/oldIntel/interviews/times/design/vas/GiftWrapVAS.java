package com.vikydroid.mylib.oldIntel.interviews.times.design.vas;

import com.practice.interviews.times.design.cakes.Cake;

public class GiftWrapVAS extends VAS {

    public GiftWrapVAS(Cake cake) {
        super(cake);
    }

    @Override
    int getCost() {
        return cake.getCost() + 50;
    }

    @Override
    String getDesc(String s) {
        return s + ", Gift Wrap added";
    }
}
