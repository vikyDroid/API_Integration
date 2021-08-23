package com.vikydroid.mylib.oldIntel.designpattern.decorator;

public class TomatoSauce extends PizzaDecorator {
    TomatoSauce(Pizza pizza) {
        super(pizza);
        System.out.println("Adding Tomato Sauce");
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Tomato Sauce";
    }

    @Override
    public double getCost() {
        return super.getCost() + .35;
    }
}
