package com.vikydroid.mylib.oldIntel.designpattern.observer;

public class CricketMatch {
    public static void main(String[] args) {
        CricketData cricketData = new CricketData();

        CurrentScore currentScore = new CurrentScore();
        cricketData.register(currentScore);

        AverageScore averageScore = new AverageScore();
        cricketData.register(averageScore);

        cricketData.update(10, 1, 4.2f);

        System.out.println("================================");

        cricketData.update(100, 5, 20.2f);

        cricketData.unRegister(currentScore);
        cricketData.unRegister(averageScore);

        cricketData.update(1000, 15, 50.2f);
    }
}
