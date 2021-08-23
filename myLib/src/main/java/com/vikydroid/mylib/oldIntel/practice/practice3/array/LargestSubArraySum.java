package com.vikydroid.mylib.oldIntel.practice.practice3.array;

public class LargestSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2, -3, -4, -1, -2, -1, -5, -3};
        System.out.println(largestSumSubArray(arr));
        System.out.println(largestSumSubArray2(arr));
    }

    //BEST as handles -ve also
    private static int largestSumSubArray(int[] arr) {
        int maxSoFar = arr[0], maxTillNow = arr[0];//Catch
        for (int value : arr) {
            maxTillNow = Math.max(value, maxTillNow + value);//Catch
            maxSoFar = Math.max(maxSoFar, maxTillNow);
        }
        return maxSoFar;
    }

    private static int largestSumSubArray2(int[] arr) {
        int maxSoFar = 0, maxTillNow = 0;
        for (int value : arr) {
            maxTillNow += value;
            if (maxTillNow < 0) {
                maxTillNow = 0;
            }
            maxSoFar = Math.max(maxSoFar, maxTillNow);
        }
        return maxSoFar;
    }
}
