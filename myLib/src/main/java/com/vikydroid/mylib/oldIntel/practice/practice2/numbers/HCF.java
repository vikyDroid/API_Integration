package com.vikydroid.mylib.oldIntel.practice.practice2.numbers;

public class HCF {
    public static void main(String[] args) {
        int a = 9;
        int b = 5;
        System.out.println(new HCF().findHCF(a, b));
        System.out.println(new HCF().findHCF2(a, b));
    }

    public int findHCF2(int a, int b) {
        if (b == 0) return a;
        return findHCF2(b, a % b);
    }

    //Eucledian theorem;
    public int findHCF(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        if (a == b) return a;

        if (a < b) return findHCF(a, b - a);
        return findHCF(a - b, b);
    }
}
