package com.vikydroid.mylib.oldIntel.practice.practice1.arrays;

public class FindSumPairInSortedRotated {

    public static void main(String[] args) {
        int[] A = {11, 15, 6, 7, 9, 10};
        System.out.println(new FindSumPairInSortedRotated().findPair(A, 16));
    }

    boolean findPair(int[] A, int x) {
        int n = A.length;
        int pivot = findPivot(A, 0, n - 1);
        if (pivot < 0) {
            return findSumPair(A, 0, n - 1, x);
        }
        return findSumPairAll(A, pivot + 1, pivot, x);
    }

    public boolean findSumPair(int[] A, int l, int r, int x) {
        int n = A.length;
        while (l != r) {
            int sum = A[l] + A[r];
            if (sum == x) {
                System.out.println("(" + A[l] + "," + A[r] + ")");
                return true;
            }
            if (sum < x) {
                l = (l + 1) % n;
            } else {
                r = (r - 1 + n) % n;
            }
        }
        return false;
    }

    public boolean findSumPairAll(int[] A, int l, int r, int x) {
        int n = A.length;
        int count = 0;
        while (l != r) {
            if (A[l] + A[r] == x) {
                count++;
                System.out.println("(" + A[l] + "," + A[r] + ")");

                r = (n + r - 1) % n;
                if (l == r) {
                    System.out.println(count);
                    return false;
                }
                l = (l + 1) % n;
            }
            if (A[l] + A[r] < x) {
                l = (l + 1) % n;
            } else if (A[l] + A[r] > x) {
                r = (r - 1 + n) % n;
            }
        }
        return false;
    }

    public int findPivot(int[] A, int l, int r) {
        if (l > r) return -1;
        if (l == r) return l;

        int mid = (l + r) / 2;
        if (A[mid - 1] > A[mid]) {
            return mid - 1;
        }
        if (A[mid] > A[mid + 1]) {
            return mid;
        }
        if (A[l] <= A[mid]) {
            return findPivot(A, mid + 1, r);
        }
        return findPivot(A, l, mid - 1);
    }
}
