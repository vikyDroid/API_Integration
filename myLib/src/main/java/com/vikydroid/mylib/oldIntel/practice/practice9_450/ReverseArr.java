package com.vikydroid.mylib.oldIntel.practice.practice9_450;


import java.util.Arrays;

public class ReverseArr {
    public static void main(String[] args) {
        char[] a = {'1', '2', '3'};
        System.out.println(Arrays.toString(a));
        mReverse2(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    static void mReverse(char[] a) {  //O(n)
        int n = a.length, l = 0, r = n - 1;
        while (l < r) {
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }

    static void mReverse2(char[] a, int l, int r) {  //O(n)
        if (l >= r) return;
        char temp = a[l];
        a[l] = a[r];
        a[r] = temp;
        mReverse2(a, l + 1, r - 1);
    }
}
