package com.vikydroid.mylib.oldIntel.practice.practice8;

import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        ArrayList<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(2);
        x.add(3);

        ArrayList<Integer> y = x;

        x.add(4);

        x = null;

        for (int i : y) {
            System.out.println(i);
        }

    }
}
