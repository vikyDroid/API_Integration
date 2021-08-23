package com.vikydroid.mylib.oldIntel.practice.practice7.array;

public class LargestSumContiguous {
    public static void main(String[] args) {
        int[] arr = {-1, -2, 0,-3, -4};
        System.out.println(maxSumContiguous2(arr));
//        System.out.println(maxSumWithPos(arr));
        System.out.println(largest(arr));
        System.out.println(largestPos(arr));
    }

    private static int maxSumContiguous(int[] arr) {
        int n = arr.length, maxSoFar = 0, max = 0;
        for (int i = 0; i < n; i++) {
            if (maxSoFar < maxSoFar + arr[i]) {
                maxSoFar = maxSoFar + arr[i];
            }
            if (max < maxSoFar) {
                max = maxSoFar;
            }
        }
        return max;
    }

    static int maxSumContiguous2(int[] arr) {
        int n = arr.length;
        int maxSum = arr[0], maxSumSoFar = arr[0];
        for (int i = 1; i < n; i++) {
            maxSum = Math.max(arr[i], maxSum + arr[i]);
            maxSumSoFar = Math.max(maxSum, maxSumSoFar);
        }
        return maxSumSoFar;
    }

    static int maxSumWithPos(int[] arr) {
        int n = arr.length;
        int maxLocal = arr[0], maxGlobal = arr[0];
        int start = 0, end = 0, s = 0;
        for (int i = 1; i < n; i++) {
            int sum = maxLocal + arr[i];
            if (arr[i] > sum) {
                maxLocal = arr[i];
                start = s;
//                end = i;
            } else {
                s = i + 1;
                maxLocal = sum;
            }
            if (maxGlobal < maxLocal) {
                maxGlobal = maxLocal;
                end = i;
                start = s;
            }
        }
        System.out.println("Start index = " + start);
        System.out.println("End index = " + end);
        return maxGlobal;
    }

    static int largest(int[] arr) {
        int maxGlobal = Integer.MIN_VALUE, maxLocal = 0;
        for (int i : arr) {
            maxLocal += i;
            maxGlobal = Math.max(maxGlobal, maxLocal);
            maxLocal = Math.max(maxLocal, 0);
        }
        return maxGlobal;
    }

    static int largestPos(int[] arr) {
        int n = arr.length;
        int maxG = Integer.MIN_VALUE, maxL = 0;
        int start = 0, end = 0, temp = 0;
        for (int i = 0; i < n; i++) {
            maxL += arr[i];
            if (maxG < maxL) {
                maxG = maxL;
                end = i;
                start = temp;
            }
            if (maxL < 0) {
                maxL = 0;
                temp = i + 1;
            }
        }
        System.out.println("Start index : " + start);
        System.out.println("Start end : " + end);
        return maxG;
    }
}
