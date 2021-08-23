package com.vikydroid.mylib.oldIntel.designpattern.prototype;

public class Sheep implements Animal {

    public Sheep() {
        System.out.println("Sheep is made");
    }

    @Override
    public Animal makeCopy() {
        System.out.println("Copy Sheep is being made");

        Sheep sheepObject = null;

        try {
            sheepObject = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return sheepObject;
    }

    @Override
    public String toString() {
        return "Baaaa!!! I am here!!!";
    }
}
