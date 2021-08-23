package com.vikydroid.mylib.oldIntel.practice.practice2.array;

import com.practice.practice.practice2.binarysearch.BinarySearch;
import com.practice.practice.practice2.binarysearch.FindPivotByBS;

public class SearchInSortedRotated {
    public static void main(String[] args) {
        int[] arr = {30, 40, 50, 10, 20};
        int key = 30;
        int pos = new SearchInSortedRotated().searchInSortedRotated(arr, key);
        System.out.println(pos);
    }

    public int searchInSortedRotated(int[] arr, int key) {
        int n = arr.length;
        int pivot = new FindPivotByBS().findPivotByBS(arr);
        if (pivot == -1) {//Array not rotated
            return new BinarySearch().binarySearch(arr, key);
        }
        if (arr[pivot] == key) {
            return pivot;
        }
        if (key >= arr[0])
            return new BinarySearch().binarySearch(arr, 0, pivot - 1, key);
        return new BinarySearch().binarySearch(arr, pivot + 1, n - 1, key);

    }
}
