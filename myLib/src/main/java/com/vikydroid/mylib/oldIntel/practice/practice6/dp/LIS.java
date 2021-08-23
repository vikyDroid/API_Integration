package com.vikydroid.mylib.oldIntel.practice.practice6.dp;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class LIS {
    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 5};
        System.out.println(lis(arr));
        System.out.println(lis3(arr));
    }

    //O(n^2)
    private static int lis(int[] arr) {
        int n = arr.length;
        if (n <= 0) return -1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //O(nlogn)
    private static int lis2(int[] arr) {
        int n = arr.length;
        if (n <= 0) return -1;
        Queue<Pair> dp = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            dp.add(new Pair(arr[i]));
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < dp.size(); j++) {
//                if (arr[i] > dp.peek(j).key) {
//                    dp.get(j).val = Math.max(dp.get(j).val + 1, dp.get(j).val);
//                    Collections.sort(dp);
//                }
            }
        }
        return /*dp.get(0).val*/0;
    }

    //O(nlogn)
    private static int lis3(int[] arr) {
        int n = arr.length;
        if (n <= 0) return -1;
        ArrayList<Pair> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp.add(new Pair(arr[i]));
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > dp.get(j).key) {
                    dp.get(i).val = Math.max(dp.get(j).val + 1, dp.get(i).val);
                    Collections.sort(dp);
                    break;
                }
            }
        }
        Collections.sort(dp);
        return dp.get(0).val;
    }

    static class Pair implements Comparable<Pair> {
        int key, val = 1;

        public Pair(int key) {
            this.key = key;
        }

        public Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public int compareTo(@NotNull Pair o) {
            return o.val - this.val;
        }
    }
}
