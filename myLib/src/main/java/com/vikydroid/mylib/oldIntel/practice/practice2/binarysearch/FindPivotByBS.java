package com.vikydroid.mylib.oldIntel.practice.practice2.binarysearch;

public class FindPivotByBS {
    public static void main(String[] args) {

        int[] arr = {6};
        int[] arr2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(new FindPivotByBS().findPivotByBS(arr));
        System.out.println(new FindPivotByBS().findPivotByBSR(arr, 0, arr.length - 1));
    }

    public int findPivotByBS(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (m > l && arr[m - 1] > arr[m]) {
                return m - 1;
            }
            if (m < r && arr[m] > arr[m + 1]) {
                return m;
            }
            if (arr[l] < arr[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public int findPivotByBSR(int[] arr, int l, int r) {
        if (l > r) return -1;
//        if (l == r) return l;
        int m = (l + r) / 2;
        if (m < r && arr[m] > arr[m + 1]) {
            return m;
        }
        if (m > l && arr[m] < arr[m - 1]) {
            return m - 1;
        }
        if (arr[l] <= arr[m]) {
            return findPivotByBSR(arr, m + 1, r);
        } else {
            return findPivotByBSR(arr, l, m - 1);
        }
    }
}
