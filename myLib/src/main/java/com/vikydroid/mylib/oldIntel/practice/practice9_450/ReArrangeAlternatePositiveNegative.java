package com.vikydroid.mylib.oldIntel.practice.practice9_450;

import java.util.Arrays;

public class ReArrangeAlternatePositiveNegative {
    public static void main(String[] args) {
        int[] a = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        System.out.println(Arrays.toString(a));
        reArrange(a);
        System.out.println(Arrays.toString(a));
    }

    static void reArrange(int[] a) {
        int curr = 0, n = a.length, firstNegative = findNegative(a, 0), firstPositive = findPositive(a, 0);
        while (curr < n - 1) { //O(n)
            int target = -1;
            if (curr % 2 == 0 && a[curr] >= 0) {
                target = firstNegative;
                firstNegative = findNegative(a, firstNegative + 1);
            } else if (curr % 2 == 1 && a[curr] < 0) {
                target = firstPositive;
                firstPositive = findPositive(a, firstPositive + 1);
            }
            if (target != -1) {
                rotate(a, curr, target);
            }
            curr++;
            if (firstPositive <= curr) firstPositive = findPositive(a, curr + 1);
            if (firstNegative <= curr) firstNegative = findNegative(a, curr + 1);
        }
    }

    static int findNegative(int[] a, int curr) {
        int n = a.length;
        for (int i = curr; i < n; i++) {
            if (a[i] < 0) return i;
        }
        return -1;
    }

    static int findPositive(int[] a, int curr) {
        int n = a.length;
        for (int i = curr; i < n; i++) {
            if (a[i] >= 0) return i;
        }
        return -1;
    }

    static void rotate(int[] a, int curr, int t) {
        int temp = a[t];
        for (int i = t; i > curr; i--) {
            a[i] = a[i - 1];
        }
        a[curr] = temp;
    }
}
