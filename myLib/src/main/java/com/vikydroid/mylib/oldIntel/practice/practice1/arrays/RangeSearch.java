package com.vikydroid.mylib.oldIntel.practice.practice1.arrays;

import java.util.Arrays;

public class RangeSearch {

    public static void main(String[] args) {
        int[] A = {0, 2, 2, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(new RangeSearch().searchRange(A, 2)));
    }

    void rangeSearch(int[] A, int item) {
        int i = binarySearch(A, item);
        int j = binarySearch(A, item - 1);
        System.out.println(i + " " + j);
    }

    private int binarySearch(int[] A, int item) {
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (item == A[mid]) {
                while (item == A[mid + 1] && mid + 1 <= end)
                    mid++;
                return mid;
            } else if (item < A[mid]) {
                end = mid - 1;
            } else if (item > A[mid]) {
                start = mid + 1;
            }
        }
        return Integer.MIN_VALUE;
    }


    int[] searchRange(int[] nums, int target) {
        int p = get_insert_index(nums, target);
        if (nums[p] != target) {
            return new int[]{-1, -1};
        }
        int q = get_insert_index(nums, target - 1);
        if (q < nums.length - 1 && nums[q] != target) {
            q = q + 1;
        }
        return new int[]{q, p};
    }

    int get_insert_index(int[] nums, int target) {
        int lo = 0, hi = 0;
        int mid = (lo + hi) / 2;
        while (mid != lo) {
            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] > target)) {
                return mid;
            } else if (nums[mid] <= target) {
                lo = mid;
            } else {
                hi = mid;
                mid = (lo + hi) / 2;
            }
        }
        return mid;
    }

}
