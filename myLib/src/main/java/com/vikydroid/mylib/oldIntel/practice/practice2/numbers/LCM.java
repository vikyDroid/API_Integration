package com.vikydroid.mylib.oldIntel.practice.practice2.numbers;

public class LCM {
    public static void main(String[] args) {
        int key = 12;
        new LCM().findLCM2(key);
    }

    //Better approach
    public void findLCM2(int key) {
        while (key % 2 == 0) {
            System.out.print(2 + " ");
            key /= 2;
        }
        for (int i = 3; i < Math.sqrt(key); i += 2) {
            while (key % i == 0) {
                System.out.print(i + " ");
                key /= 2;
            }
        }
        /*while (i <= Math.sqrt(key)) {
            if (key % i == 0) {
                System.out.print(i + " ");
                key /= i;
            } else {
                i += 2;
            }
        }*/
        if (key > 2) {
            System.out.print(key);
        }

    }

    //Simple Approcah
    public void findLCM(int key) {
        if (key == 0 || key == 1) {
            return;
        }
        int i = 2;
        while (i <= key) {
            if (key % i == 0) {
                System.out.print(i + " ");
                key /= i;
            } else {
                i++;
            }
        }
    }
}
