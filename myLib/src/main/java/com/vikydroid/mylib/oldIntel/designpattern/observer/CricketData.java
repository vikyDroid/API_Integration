package com.vikydroid.mylib.oldIntel.designpattern.observer;

import java.util.ArrayList;

public class CricketData implements Subject {
    int run, wicket;
    float over;
    ArrayList<Observer> observers;

    public CricketData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unRegister(Observer o) {
        observers.remove(observers.indexOf(o));
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(this.run, this.wicket, this.over);
        }
    }

    void update(int run, int wicket, float over) {
        this.run = run;
        this.wicket = wicket;
        this.over = over;
        notifyObserver();
    }
}
