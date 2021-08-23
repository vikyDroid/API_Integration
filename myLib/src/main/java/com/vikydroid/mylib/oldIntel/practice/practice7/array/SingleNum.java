package com.vikydroid.mylib.oldIntel.practice.practice7.array;

public class SingleNum {
    public static void main(String[] args) {
        int[] arr = {7, 3, 5, 4, 5, 3, 4};
        System.out.println(singleNUm(arr));
//        System.out.println(2^6);
    }

    private static int singleNUm(int[] arr) {
        int res = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            res = res ^ arr[i];
        }
        return res;
    }
}
