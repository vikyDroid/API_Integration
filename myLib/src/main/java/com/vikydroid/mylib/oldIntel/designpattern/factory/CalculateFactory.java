package com.vikydroid.mylib.oldIntel.designpattern.factory;

public class CalculateFactory {

    public Calculate getCalculationObj(String s) {
        if (s.equalsIgnoreCase("add")) {
            return new Add();
        } else if (s.equalsIgnoreCase("subtract")) {
            return new Subtract();
        } else if (s.equalsIgnoreCase("divide")) {
            return new Division();
        } else return null;
    }
}
