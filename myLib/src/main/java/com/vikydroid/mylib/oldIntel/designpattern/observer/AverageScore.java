package com.vikydroid.mylib.oldIntel.designpattern.observer;

public class AverageScore implements Observer {
    private int predictScore;
    private float runRate;

    @Override
    public void update(int run, int wicket, float over) {
        runRate = (float) run / (over * 6);
        predictScore = (int) (runRate * 50);
        display();
    }

    private void display() {
        System.out.println("Run rate : " + runRate);
        System.out.println("Score predicted : " + predictScore);
    }
}
