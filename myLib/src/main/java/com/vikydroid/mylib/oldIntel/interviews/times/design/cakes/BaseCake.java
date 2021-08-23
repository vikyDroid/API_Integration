package com.vikydroid.mylib.oldIntel.interviews.times.design.cakes;

import com.practice.interviews.times.design.vas.VAS;

import java.util.List;

public abstract class BaseCake implements Cake {
    Cake cake;

    BaseCake(Cake cake) {
        this.cake = cake;
    }

    List<VAS> vas = null;

    void addVAS(List<VAS> vas) {
        this.vas = vas;
    }


    @Override
    public int getCost() {
        return 0;
    }

    @Override
    public String getDesc() {
        return null;
    }
}
