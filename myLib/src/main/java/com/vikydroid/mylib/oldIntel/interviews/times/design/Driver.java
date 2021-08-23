package com.vikydroid.mylib.oldIntel.interviews.times.design;

import com.practice.interviews.times.design.cakes.*;
import com.practice.interviews.times.design.enums.FLAVOR_TYPE;
import com.practice.interviews.times.design.enums.VAS_TYPE;
import com.practice.interviews.times.design.vas.*;

public class Driver {
    public static void main(String[] args) {
        Cake cake = CakeFactory.getCake(FLAVOR_TYPE.FRUIT);
        VAS_Factory.getVAS(VAS_TYPE.CREAM, cake);
        if (cake != null) {
            System.out.println("Total Cost :" + cake.getCost());
            System.out.println(cake.getDesc());
        }

    }


}
