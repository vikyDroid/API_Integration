package com.vikydroid.mylib.oldIntel.practice.practice9_450;

public class FindDuplicateWithoutAlteringArr {
    public static void main(String[] args) {
        int[] a = {2, 6, 4, 1, 3, 1, 5};
        System.out.println(util2(a));
    }

    static int util2(int[] a) {
        int s = a[0], f = a[0], n = a.length;
        s = a[s];
        f = a[a[f]];
        while (s != f) {
            s = a[s];
            f = a[a[f]];
            if (s == f) break;
        }
        s = a[0];
        while (s != f) {
            s = a[s];
            f = a[f];
            if (s==f) break;
        }
        return s;
    }
}
