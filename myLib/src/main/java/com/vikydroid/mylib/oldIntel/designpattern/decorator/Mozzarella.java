package com.vikydroid.mylib.oldIntel.designpattern.decorator;

public class Mozzarella extends PizzaDecorator {
    Mozzarella(Pizza pizza) {
        super(pizza);
        System.out.println("Adding Moz");
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Moz";
    }

    @Override
    public double getCost() {
        return super.getCost() + .50;
    }
}
