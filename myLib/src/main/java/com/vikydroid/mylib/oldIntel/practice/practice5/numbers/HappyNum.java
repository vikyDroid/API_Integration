package com.vikydroid.mylib.oldIntel.practice.practice5.numbers;

import java.util.HashSet;

public class HappyNum {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        System.out.println(happyNum(19, set));
    }

    private static boolean happyNum(int x, HashSet<Integer> set) {
        int ans = getAns(x);
        if (ans == 1) return true;
        if (set.contains(ans)) return false;
        else {
            set.add(ans);
            return happyNum(ans, set);
        }
    }

    private static int getAns(int x) {
        int ans = 0;
        while (x > 0) {
            int dig = x % 10;
            ans += dig * dig;
            x /= 10;
        }
        return ans;
    }
}
