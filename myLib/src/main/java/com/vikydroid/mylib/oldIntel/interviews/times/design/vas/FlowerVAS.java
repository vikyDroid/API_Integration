package com.vikydroid.mylib.oldIntel.interviews.times.design.vas;

import com.practice.interviews.times.design.cakes.Cake;

public class FlowerVAS extends VAS {

    public FlowerVAS(Cake cake) {
        super(cake);
    }

    @Override
    int getCost() {
        return cake.getCost() + 300;
    }

    @Override
    String getDesc(String s) {
        return s + ", Flower added";
    }
}
