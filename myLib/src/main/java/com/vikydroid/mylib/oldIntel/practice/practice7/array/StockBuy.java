package com.vikydroid.mylib.oldIntel.practice.practice7.array;

import java.util.ArrayList;

public class StockBuy {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 2, 4};
        ArrayList<ArrayList<Integer>> list = getProfit(arr);
        for (ArrayList<Integer> l : list) {
            System.out.print("(");
            for (Integer i : l) {
                System.out.print(+i + ",");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> getProfit(int[] arr) {
        int n = arr.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> l = new ArrayList<>();
            int buy = getMin(arr, i);
            if (buy == -1 && i == 0) return res;
            if (buy != -1) {
                l.add(buy);
                int sell = getMax(arr, buy + 1);
                if (sell != -1) {
                    l.add(sell);
                    res.add(l);
                    i = sell;
                }
            }
        }

        return res;
    }

    private static int getMin(int[] arr, int i) {
        for (int j = i; j < arr.length - 1; j++) {
            if (arr[j] < arr[j + 1]) {
                return j;
            }
        }
        return -1;
    }

    private static int getMax(int[] arr, int i) {
        for (int j = i; j < arr.length - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                return j;
            }
        }
        return arr.length - 1;
    }
}
