package com.vikydroid.mylib.oldIntel.practice.practice1.arrays;

import java.util.Arrays;

public class RotateBy {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7};
        new RotateBy().rotateCyclic(A, 2);
        System.out.println(Arrays.toString(A));
    }

    // T = O(d*n) , S = O(1)
    void leftRotateBy(int[] A, int d) {
        int n = A.length;
        for (int i = 0; i < d; i++) {
            leftShiftByOne(A, n);
        }
    }

    private void leftShiftByOne(int[] A, int n) {
        int i, temp = A[0];
        for (i = 0; i < n - 1; i++) {
            A[i] = A[i + 1];
        }
        A[i] = temp;
    }

    void leftRotateBy2(int[] A, int d) {
        int n = A.length;
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = A[i];
        }
        for (int i = 0; i < n - d; i++) {
            A[i] = A[i + d];//d should be less than size

        }
//        int v = 0;
        for (int i = n - d, x = 0; i < n; i++, x++) {
            A[i] = temp[x];
        }
    }

    void rotateByReverse(int[] A, int d) {
        int n = A.length;
        reverse(A, 0, d - 1);
        reverse(A, d, n - 1);
        reverse(A, 0, n - 1);
    }

    private void reverse(int[] A, int start, int end) {
        while (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }

    private void rotateCyclic(int[] A, int d) {
        int i, n = A.length;
        int temp = A[n - 1];
        for (i = n - 1; i > 0; i--) {
            A[i] = A[i - 1];
        }
        A[0] = temp;
    }


}
