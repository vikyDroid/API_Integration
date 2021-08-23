package com.vikydroid.mylib.oldIntel.practice.practice7.array;

import java.util.ArrayList;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] arr = {4, 2, 4, 5, 2, 3, 1, 4};
        findDuplicates(arr);
//        findDuplicates(arr, 5);
        System.out.println();
    }

    private static void findDuplicates(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[Math.abs(arr[i])] < 1)
                System.out.print(Math.abs(arr[i]) + " ");
            else
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
        }
    }

    static void findDuplicates(int[] arr, int size) {
        int[] count = new int[size + 1];
        for (int j : arr) {
            if (count[j] == 1) {
                System.out.print(j + " ");
            } else
                count[j]++;
        }
    }

    static {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
    }
}
