package com.vikydroid.mylib.oldIntel.practice.practice5.array;

public class SortedRotated {
    public static void main(String[] args) {
        int[] arr = {30, 40, 50, 10, 20};
        int x = 10;
        sortedRotated(arr, x);
    }

    static void sortedRotated(int[] arr, int x) {
        int pivot = -1, n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                pivot = i;
            }
        }
        if (x == arr[0]) {
            System.out.println(0);
        } else if (x < arr[0]) {
            System.out.println(binSearch(arr, pivot + 1, arr.length - 1, x));
        } else {
            System.out.println(binSearch(arr, 0, pivot, x));
        }
    }

    private static int binSearch(int[] arr, int start, int end, int x) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (x == arr[mid]) return mid;
        else if (x < arr[mid]) return binSearch(arr, start, mid - 1, x);
        else return binSearch(arr, mid + 1, end, x);
    }
}
