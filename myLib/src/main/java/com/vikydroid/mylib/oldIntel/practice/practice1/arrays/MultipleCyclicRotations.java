package com.vikydroid.mylib.oldIntel.practice.practice1.arrays;

public class MultipleCyclicRotations {

    public static void main(String[] args) {

    }

    public void multipleCyclicRotations(int[] A, int r) {
        int n = A.length;
        r = r % n;
        int pivot = new FindSumPairInSortedRotated().findPivot(A, 0, n - 1);
        for (int i = 0; i < n; i++) {
            int newPos = (n + i - pivot) % n;
            A[i] = A[newPos];
        }
    }
}
