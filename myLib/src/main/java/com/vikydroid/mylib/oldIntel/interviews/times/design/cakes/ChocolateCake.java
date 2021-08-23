package com.vikydroid.mylib.oldIntel.interviews.times.design.cakes;

public class ChocolateCake implements Cake {

    @Override
    public int getCost() {
        return baseCost + 160;
    }

    @Override
    public String getDesc() {
        return baseDesc + ", Chocolate " + flavor;
    }
}
