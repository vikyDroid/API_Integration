package com.vikydroid.mylib.oldIntel.interviews;

public class CountSquaresInRectangle {

    public static void main(String[] args) {
        int l = 5;
        int b = 11;
        long startTime = System.nanoTime();
        int ans = getAns(b, l);
        System.out.println("ANS :" + ans);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(estimatedTime);

    }

    static int getAns(int l, int b) {
        if (l > b) {
            return getNum(l, b);
        } else {
            int temp = b;
            b = l;
            l = temp;
            return getNum(b, l);
        }
    }

    static int getNum(int l, int b) {
        int num = 0, temp = 0;
        while (l > 0 && b > 0) {
            if (l == 1 && b == 1) {
                num += 1;
                return num;
            }
            temp = getSquare(l, b);
            num += temp;
            int t = b;
            b = l - (temp * b);
            l = t;
        }
        return num;
    }

    static int getSquare(int l, int b) {
        int temp = b;
        int count = 0;
        while (b < l) {
            count++;
            b += temp;
        }
        return count;
    }
}