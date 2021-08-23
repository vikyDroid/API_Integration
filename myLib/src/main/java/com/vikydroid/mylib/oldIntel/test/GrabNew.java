package com.vikydroid.mylib.oldIntel.test;

import kotlin.math.UMathKt;

public class GrabNew {

    //5 80 10 75 = 5+10+75
    //15 10 7 12 = 5+10+12, 10+22
    //-5, 0, 5, 10

    //a[i]>a[i-1]
    public static void main(String[] args) {
        //15 10 7 12
        //sum1 = 15
        //sum2 = 10+12 = 22
        //sum3 = 7 + 12 = 19
        int[] a = {4, 3, 2, 1}; //4
        System.out.println(maxSum(a));
    }

    //O(n^2)
    static int maxSum(int[] a) {
        int n = a.length, maxVal, maxSum, maxSumGlobal = a[0];
        for (int j = 0; j < n; j++) {
            maxVal = a[j];
            maxSum = a[j];
            for (int i = j + 1; i < n; i++) {
                if (a[i] > maxVal) {
                    maxVal = a[i];
                    maxSum = maxSum + a[i];
                    maxSumGlobal = Math.max(maxSumGlobal, maxSum);
                }
            }
        }
        return maxSumGlobal;
    }
}
