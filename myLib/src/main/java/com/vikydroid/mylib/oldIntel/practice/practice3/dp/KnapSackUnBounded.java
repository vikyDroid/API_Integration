package com.vikydroid.mylib.oldIntel.practice.practice3.dp;

public class KnapSackUnBounded {
    public static void main(String[] args) {
        int[] val = {1, 30};
        int[] wt = {1, 50};
        int W = 100;
        System.out.println(knapSackUnBoundedR(val, wt, W, val.length));
        System.out.println(knapSackUnBoundedDP(val, wt, W, val.length));

        val = new int[]{10, 40, 50, 70};
        wt = new int[]{1, 3, 4, 5};
        W = 8;
        System.out.println(knapSackUnBoundedR(val, wt, W, val.length));
        System.out.println(knapSackUnBoundedDP(val, wt, W, val.length));
    }

    //f(n) = max(f(n-1)+v[n-1], f(n));
    static int knapSackUnBoundedR(int[] v, int[] wt, int w, int n) {
        if (n <= 0) return 0;
        int profit = knapSackUnBoundedR(v, wt, w, n - 1);
        if (w < wt[n - 1])
            return profit;
        return Math.max(v[n - 1] + knapSackUnBoundedR(v, wt, w - wt[n - 1], n), profit);
    }

    static int knapSackUnBoundedDP(int[] v, int[] wt, int w, int n) {
        int[] a = new int[w + 1];
        for (int i = 1; i <= w; i++) {
            for (int j = 0; j < n; j++) {
                if (wt[j] <= i)
                    a[i] = Math.max(a[i], v[j] + a[i - wt[j]]);
            }

        }
        return a[w];
    }
}
