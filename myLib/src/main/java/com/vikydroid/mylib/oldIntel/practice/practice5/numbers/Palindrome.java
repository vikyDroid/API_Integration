package com.vikydroid.mylib.oldIntel.practice.practice5.numbers;

public class Palindrome {
    public static void main(String[] args) {
        int x = 1451;

        int pal = getPal(x);
        System.out.println(pal == x);
    }

    private static int getPal(int x) {
        int ans = 0;
        while (x > 0) {
            ans *= 10;
            ans += (x % 10);
            x /= 10;
        }
        return ans;
    }
}
