package com.vikydroid.mylib.oldIntel.practice.practice5.array;

public class MissingNum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        missingNum(arr);
    }

    private static void missingNum(int[] arr) {
        int sum = 0;
        for (int i = 1; i <= arr.length + 1; i++) {
            sum += i;
        }
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum2 += arr[i];
        }
        System.out.println(sum - sum2);
    }
}
