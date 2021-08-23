package com.vikydroid.mylib.oldIntel.practice.practice5.array.erroneous;

public class StockProblem {
    public static void main(String[] args) {
        int[] arr = {100, 180, 260, 310, 40, 535, 695};
        buy(arr, 0);
    }

    private static void buy(int[] arr, int i) {
        int last = arr.length - 1;
        int secondLast = last-1;
        while (i < secondLast) {
            if (arr[i] < arr[i + 1]) {
                System.out.println("Buy at Day " + i);
                break;
            } else i++;
        }
        if (i == secondLast) {
            System.out.println("Can't earn profit");
            return;
        }
        sell(arr, i + 1);
    }

    private static void sell(int[] arr, int i) {
        int last = arr.length - 1;
        while (i < last) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("Sell at Day " + i);
                break;
            } else i++;
        }
        //could go wrong
        if (i == last) {
            System.out.println("Sell at Day " + i);
            return;
        }
        buy(arr, i + 1);
    }
}
