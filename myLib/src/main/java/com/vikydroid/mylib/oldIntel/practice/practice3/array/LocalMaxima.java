package com.vikydroid.mylib.oldIntel.practice.practice3.array;

public class LocalMaxima {
    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 6, 4, 8, 1, 16};
        System.out.println(localMaxima(arr));
    }

    private static int localMaxima(int[] arr) {
        int curr = arr[0], maxSoFar = 0;
        for (int i = 1; i < arr.length ; i++) {
            if (curr < arr[i]) {
                maxSoFar = Math.max(maxSoFar, arr[i] - curr);
//                curr = arr[i + 1];
            }
        }
        return maxSoFar;
    }
}
