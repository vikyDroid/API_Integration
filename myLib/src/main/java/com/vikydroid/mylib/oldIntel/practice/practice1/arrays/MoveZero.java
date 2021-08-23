package com.vikydroid.mylib.oldIntel.practice.practice1.arrays;

import com.vikydroid.mylib.oldIntel.practice.practice1.constants.MyConstants;

import java.util.Arrays;

public class MoveZero {
    public static void main(String[] args) {
        int[] A = {0, 1, 0, 3, 12, 0};
        new MoveZero().moveZeroN(A, 0);
        System.out.println(Arrays.toString(A));
    }

    void moveZero(int[] A, int item) {
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            if (A[start] == item) {
                if (A[end] == item) {
                    end--;
                }
                MyConstants.swap(A, start, end);
                end--;
            } else {
                start++;
            }
        }
    }

    void moveZero(int[] nums) {
        int start = 0;
        int n = nums.length;
        int end = n - 1;
        int i = 0;
        while (i < end) {
            if (nums[i] == 0 && i != end) {
                int j = i + 1;
                while (j <= end - 1 && nums[j] == 0) {
                    j++;
                }
                MyConstants.swap(nums, i, j);
                i++;
            }
        }
    }

    void moveZeros(int[] A, int item) {
        int j = 0, n = A.length;
        for (int i = 0; i < n; i++) {
            if (item != A[i]) {
                MyConstants.swap(A, i, j++);
//                j++;
            }
        }
    }

    void moveZeroN(int[] A, int item) {
        int j = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] != item) {
                A[j] = A[i];
                j++;
            }
        }
        for (int k = j; k < n; k++) {
            A[k] = item;
        }
    }

}
