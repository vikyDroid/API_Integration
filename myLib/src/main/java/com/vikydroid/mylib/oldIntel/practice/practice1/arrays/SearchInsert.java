package com.vikydroid.mylib.oldIntel.practice.practice1.arrays;

public class SearchInsert {
    public static void main(String[] args) {
        int[] A = {3, 6, 7, 8, 10};
        System.out.println(new SearchInsert().searchInsert(A, 5));
    }

    int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int i = binarySearch(nums, target);
        while (i < 0) {
            target--;
            i = binarySearch(nums, target);
        }
        return i;

    }

    private int binarySearch(int[] A, int item) {
        int n = A.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (item == A[mid]) return mid;
            else if (item < A[mid]) end = mid - 1;
            else if (item > A[mid]) start = mid + 1;
        }
        return -1;
    }
}
