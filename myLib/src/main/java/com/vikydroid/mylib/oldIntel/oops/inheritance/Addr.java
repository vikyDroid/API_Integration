package com.vikydroid.mylib.oldIntel.oops.inheritance;

public class Addr {
    protected int num = 10;
    String s = "paa address";

    @Override
    public String toString() {
        return "Addr{" +
                "s='" + s + '\'' +
                '}';
    }

     class TesttInner {
        void testfun() {
            num = 1000;
        }
    }
}
