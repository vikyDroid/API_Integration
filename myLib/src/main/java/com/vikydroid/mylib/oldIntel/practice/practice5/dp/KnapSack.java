package com.vikydroid.mylib.oldIntel.practice.practice5.dp;

public class KnapSack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {70, 20, 70};
        int w = 50;
        System.out.println(maxVal(val, wt, val.length, w));
    }

    private static int maxVal(int[] val, int[] wt, int n, int w) {
        if (w <= 0) return 0;
        if (n <= 0) return 0;
        if (wt[n - 1] > w)
            return maxVal(val, wt, n - 1, w);
        return Math.max(val[n - 1] + maxVal(val, wt, n - 1, w - wt[n - 1]),
                maxVal(val, wt, n - 1, w));
    }
}
