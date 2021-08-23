package com.vikydroid.mylib.oldIntel.interviews.times;

public class TimesInternet {
    public static void main(String[] args) {
        int wt = 8;
        int[] w = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20};

        System.out.println(myFun(w, p, wt, w.length));
        System.out.println(maxP(w, p, wt, w.length));
        System.out.println(maxP_gfg(p, p.length));
        System.out.println(maxProfit(p, p.length));
        System.out.println(maxProfitDP(p, p.length));
    }


    static int myFun(int[] w, int[] p, int wt, int n) {
        if (wt <= 0 || n <= 0) return 0;
        int profit = myFun(w, p, wt, n - 1);
        if (wt < w[n - 1]) {
            return profit;
        }
//        if (n == 0 && w[n] <= wt) return p[n];
//        if (wt == w[n]) return p[n];
        return Math.max(profit, p[n - 1] + myFun(w, p, wt - w[n - 1], n));
    }

    static int maxP(int[] w, int[] p, int wt, int n) {
        if (wt <= 0 || n < 0) return 0;
        if (n == 0 && w[n] <= wt) return p[n];
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum = Math.max(sum, p[i] + maxP(w, p, wt - w[i], n - 1 - i));
        }
        return sum;
    }

    static int maxP_gfg(int[] p, int n) {
        if (n <= 0) return 0;
//        if (n == 0) return p[n];
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum = Math.max(sum, p[i] + maxP_gfg(p, n - 1 - i));
        }
        return sum;
    }

    static int maxProfit(int[] p, int n) {
        if (n <= 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, p[i] + maxProfit(p, n - 1 - i));
        }
        return max;
    }

    static int maxProfitDP(int[] p, int n) {
        int[] a = new int[n + 1];
        a[0] = 0;
        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, p[j] + a[i - 1 - j]);
            }
            a[i] = max;
        }
        return a[n];
    }

    /*static int maxProfit(int[] a, int[] w, int wt) {
        int n = a.length, l = 0, r = n - 1;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], w[i]);
        }
        for (int i = 0; i < n; i++) {
            int diff = wt - a[i];
            max = Math.max(max, a[i]);
                if (map.containsKey(diff)) {

                } else {

                }
        }

    }*/

}

