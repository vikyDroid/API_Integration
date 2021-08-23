package com.vikydroid.mylib.oldIntel.test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestPartition {
    public static void main(String[] args) {

        int prod = 1;
        while (prod <= Integer.MAX_VALUE / 3) {
            prod *= 3;
            System.out.println(prod);
        }
        System.out.println();
        System.out.println(Integer.MAX_VALUE / 3);
    }

    private static boolean partition(int[] arr, int k) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        if (k == 0 || sum % k != 0)
            return false;
        boolean[] used = new boolean[arr.length];
        return partitionNum(k, 0, 0, sum / k, used, arr);
    }

    static boolean partitionNum(int k, int start, int currVal, int total, boolean[] used, int[] arr) {
        if (k == 1)
            return true;
        if (currVal == total)
            return partitionNum(k - 1, 0, 0, total, used, arr);
        for (int i = start; i < arr.length; i++) {
            if (!used[i] && currVal + arr[i] <= total) {
                used[i] = true;
                if (partitionNum(k, i + 1, currVal + arr[i], total, used, arr))
                    return true;
                else
                    used[i] = false;
            }
        }
        return false;
    }
}
