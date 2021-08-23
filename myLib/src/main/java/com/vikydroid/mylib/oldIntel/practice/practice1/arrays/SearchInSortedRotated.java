package com.vikydroid.mylib.oldIntel.practice.practice1.arrays;

import com.vikydroid.mylib.oldIntel.practice.practice1.search.BinarySearch;

import java.util.Scanner;

public class SearchInSortedRotated {

    public static void main(String[] args) {
        /*int[] A = {1, 2, 3, 4, 5};
        System.out.println(new SearchInSortedRotated()
                .searchInSortedRotated(A, 0, A.length - 1, 1));*/
        System.out.println("Enter Values\n");

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            int n = s.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }
            int k = s.nextInt();
            System.out.println(new SearchInSortedRotated()
                    .searchInSortedRotated(a, 0, a.length - 1, k));
            t--;
        }

    }

    int searchInSortedRotated(int[] A, int l, int r, int key) {
        int pivot = new FindSumPairInSortedRotated().findPivot(A, l, r);
        if (key == A[pivot]) {
            return pivot;
        } else if (A[0] <= key) {
            return new BinarySearch().binarySearch(A, l, pivot - 1, key);
        } else return new BinarySearch().binarySearch(A, pivot + 1, r, key);

    }
}
