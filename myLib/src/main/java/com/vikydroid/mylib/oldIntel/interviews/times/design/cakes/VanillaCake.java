package com.vikydroid.mylib.oldIntel.interviews.times.design.cakes;

public class VanillaCake implements Cake {


    @Override
    public int getCost() {
        return baseCost + 140;
    }

    @Override
    public String getDesc() {
        return baseDesc + ", Vanilla" + flavor;
    }
}
