package com.vikydroid.mylib.oldIntel.interviews.times.design.cakes;

public class FruitCake implements Cake {


    @Override
    public int getCost() {
        return baseCost + 120;
    }

    @Override
    public String getDesc() {
        return baseDesc + ", Fruit"+ flavor;
    }
}
