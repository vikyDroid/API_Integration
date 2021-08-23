package com.vikydroid.mylib.oldIntel.practice.practice7.numbers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HappyNum {
    public static void main(String[] args) {
        int n = 20;
        Set<Integer> set = new HashSet<>();
        System.out.println(isHappy(n, set));
    }

    private static int isHappy(int n, Set<Integer> set) {
        int sum = 0;
        if (n == 1) return 1;
        else if (set.contains(n)) return 0;
        else set.add(n);
        while (n > 0) {
            int sum1 = n % 10;
            sum += sum1 * sum1;
            n /= 10;
        }
        return isHappy(sum, set);
    }
}
