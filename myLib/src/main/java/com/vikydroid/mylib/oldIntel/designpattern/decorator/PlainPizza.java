package com.vikydroid.mylib.oldIntel.designpattern.decorator;

public class PlainPizza implements Pizza {

    PlainPizza() {
        System.out.println("Adding Dough");
    }

    @Override
    public String getDescription() {
        return "Dough";
    }

    @Override
    public double getCost() {
        return 4.00;
    }
}
