package com.vikydroid.mylib.oldIntel.designpattern.prototype;

public class TestPrototype {
    public static void main(String[] args) {
        Sheep sheep = new Sheep();

        Sheep sheep1 = (Sheep) new CloneFactory().getCopy(sheep);

        System.out.println("Sheep: " + System.identityHashCode(sheep));
        System.out.println("Sheep1: " + System.identityHashCode(sheep1));
//        System.out.println("Sheep: " + sheep1.hashCode());
    }
}
