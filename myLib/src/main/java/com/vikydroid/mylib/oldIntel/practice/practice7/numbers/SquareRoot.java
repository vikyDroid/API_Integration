package com.vikydroid.mylib.oldIntel.practice.practice7.numbers;

public class SquareRoot {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(sqrt(n));
        System.out.println(sqrt2(n));
    }

    //O(sqrt(n))
    static int sqrt(int n) {
        if (n == 0 || n == 1) return n;
        for (int i = 1; i <= n / 2; i++) {
            int prod = i * i;
            if (prod == n) return i;
            else if (prod > n) return i - 1;
        }
        return 0;
    }

    //O(logn)
    static int sqrt2(int n) {
        int l = 0, r = (n / 2) + 1, ans = 0;

        while (l <= r) {
            int mid = (l + r) / 2, prod = mid * mid;
            if (prod == n) return mid;
            else if (prod < n) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
