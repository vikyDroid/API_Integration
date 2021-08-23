package com.vikydroid.mylib.oldIntel.practice.practice1.constants;

public class MyConstants {
    public static int[] a = {9, 5, 2, 1, 10, 3, 4, -10};
//    public static int[] arr = {9,5, 2, 1, 10, 0, 988, 87, 566, 7, 9, 944, 55, 88, 33};

    public static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
