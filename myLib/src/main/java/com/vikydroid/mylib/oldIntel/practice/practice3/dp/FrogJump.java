package com.vikydroid.mylib.oldIntel.practice.practice3.dp;

import java.util.Arrays;
//https://www.youtube.com/watch?v=cETfFsSTGJI
public class FrogJump {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 1, 0, 9};
        System.out.println(maxJump(arr));
    }

    //O(n^2) time O(n) space
    private static int maxJump(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] navigation = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i <= j + arr[j]) {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                    navigation[i] = j;
                }
            }
        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(dp));
//        System.out.println(Arrays.toString(navigation));

        //Printing navigation
        /*int size = dp[n - 1], k = size - 1;
        int[] res = new int[size];
        int temp = navigation[navigation.length - 1];
        while (k >= 0) {
            res[k] = arr[temp];
            temp = navigation[temp];
            k--;
        }
        System.out.println();*/
        return dp[n - 1];
    }

    //O(n) time and O(1) space
    static int minJumps(int arr[]) {
        if (arr.length <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        // Start traversing array
        for (int i = 1; i < arr.length; i++) {
            // Check if we have reached
// the end of the array
            if (i == arr.length - 1)
                return jump;

            // updating maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            // we use a step to get to the current index
            step--;

            // If no further steps left
            if (step == 0) {
                // we must have used a jump
                jump++;

                // Check if the current
// index/position or lesser index
                // is the maximum reach point
// from the previous indexes
                if (i >= maxReach)
                    return -1;

                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }

        return -1;
    }
}
