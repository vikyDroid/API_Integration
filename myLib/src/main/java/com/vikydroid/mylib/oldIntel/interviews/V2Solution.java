package com.vikydroid.mylib.oldIntel.interviews;

public class V2Solution {
    public static void main(String[] args) {
        int[] a = {1, 1, 0, 1, 1, 1};
        System.out.println(max(a));
    }

    private static int max(int[] a) {
        int n = a.length, lc = 0, gc = 0;
        boolean isFirst = true;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] == 1 && a[i + 1] == 1) {
                if (isFirst) {
                    lc += 2;
                    isFirst = false;
                } else {
                    lc += 1;
                }
                gc = Math.max(gc, lc);
            } else {
                lc = 0;
            }
        }
        return gc;
    }

}
