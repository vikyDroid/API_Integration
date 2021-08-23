package com.vikydroid.mylib.oldIntel.designpattern.decorator;

public abstract class PizzaDecorator implements Pizza {

    protected Pizza pizza;

    PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}
