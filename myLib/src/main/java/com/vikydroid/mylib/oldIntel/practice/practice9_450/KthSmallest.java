package com.vikydroid.mylib.oldIntel.practice.practice9_450;

public class KthSmallest {
    public static void main(String[] args) {
        int[] a = {7, 10, 4, 20, 15};
        int k = 4;
//        Arrays.sort(a);
//        System.out.println(a[k - 1]);
        System.out.println(getKthSmallest(a, k));
    }

    static int getKthSmallest(int[] a, int k) {
        int min = Integer.MAX_VALUE, m = 0, l = 0, n = a.length, r = n - 1;
        while (k-- > 0) {
            min = Integer.MAX_VALUE;
            for (int i = l; i < n; i++) {
                if (min > a[i]) {
                    m = i;
                    min = a[i];
                }
            }
            int temp = a[m];
            a[m] = a[l];
            a[l] = temp;
            l++;
        }
        return a[l - 1];
    }
}
