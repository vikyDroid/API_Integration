package com.vikydroid.mylib.oldIntel.interviews.times.design.vas;

import com.vikydroid.mylib.oldIntel.interviews.times.design.cakes.Cake;
import com.vikydroid.mylib.oldIntel.interviews.times.design.enums.VAS_TYPE;

public class VAS_Factory {
    public static VAS getVAS(VAS_TYPE type, Cake cake) {
        switch (type) {
            case CREAM:
                return new CreamVAS(cake);
            case FLOWER:
                return new FlowerVAS(cake);
            case GIFT_WRAP:
                return new GiftWrapVAS(cake);
        }
        return null;
    }
}
