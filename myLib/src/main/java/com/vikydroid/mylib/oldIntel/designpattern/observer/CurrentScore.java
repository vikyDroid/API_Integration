package com.vikydroid.mylib.oldIntel.designpattern.observer;

public class CurrentScore implements Observer {
    private int run, wicket;
    private float over;

    @Override
    public void update(int run, int wicket, float over) {
        this.run = run;
        this.wicket = wicket;
        this.over = over;
        display();
    }

    private void display() {
        System.out.println("Run : " + run);
        System.out.println("Wicket : " + wicket);
        System.out.println("Over : " + over);
    }
}
