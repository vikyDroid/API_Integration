package com.vikydroid.mylib.oldIntel.practice.practice3.array;

import java.util.Arrays;

public class SumPair {
    public static void main(String[] args) {
        int arr[] = {1, 5, 7, -1, 5};
        int sum = 6;
        printPairs(arr, sum);
    }

    private static void printPairs(int[] arr, int sum) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int total = arr[left] + arr[right];
            if (total == sum) {
                System.out.println("(" + arr[left] + "," + arr[right] + ")");
                left++;
                right--;
            } else if (total < sum) {
                left++;
            } else right--;
        }
    }
}
