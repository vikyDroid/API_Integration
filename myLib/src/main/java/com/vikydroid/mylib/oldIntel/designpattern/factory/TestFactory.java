package com.vikydroid.mylib.oldIntel.designpattern.factory;

public class TestFactory {

    public static void main(String[] args) {
        Calculate calculate = null;
        calculate = new CalculateFactory().getCalculationObj("divide");
        calculate.calc(2, 2);
    }
}
