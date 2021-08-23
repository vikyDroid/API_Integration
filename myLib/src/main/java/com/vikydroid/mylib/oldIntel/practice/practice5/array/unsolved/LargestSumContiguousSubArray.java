package com.vikydroid.mylib.oldIntel.practice.practice5.array.unsolved;

//Kadane's Algo
public class LargestSumContiguousSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        largestSumContiguousSubArray(arr);
    }

    private static void largestSumContiguousSubArray(int[] arr) {
        int maxTillHere = 0, maxSoFar = Integer.MIN_VALUE;
        int start = 0, end = 0, temp = 0;
        for (int i = 0; i < arr.length; i++) {
            maxTillHere += arr[i];
            if (maxSoFar < maxTillHere) {
                maxSoFar = maxTillHere;
                end = i;
                start = temp;
            }
            if (maxTillHere < 0) {
                maxTillHere = 0;
                temp = i + 1;
            }
        }
        System.out.println("Start Ind : " + start);
        System.out.println("End Index : " + end);
        System.out.println("Max val :"+ maxSoFar);
    }
}
