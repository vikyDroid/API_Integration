package com.vikydroid.mylib.oldIntel.practice.practice9_450;

import java.util.Arrays;
import java.util.HashMap;

import static com.practice.practice.practice1.constants.MyConstants.swap;

public class MoveAllNegative {
    public static void main(String[] args) {
        int[] a = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        System.out.println(Arrays.toString(a));
        move4(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));



    }

    static void move4(int[] a, int l, int r) { //using merge sort logic
        if (l < r) {
            int m = l + (r - l) / 2;
            move4(a, l, m);
            move4(a, m + 1, r);

            reArrange(a, l, m, r);
        }
    }

    static void reArrange(int[] a, int l, int m, int r) {
        int i = l, j = m + 1;
        while (i <= m && a[i] < 0) i++;
        while (j <= r && a[j] < 0) j++;

        reverse(a, i, m);
        reverse(a, m + 1, j-1);
        reverse(a, i, j-1);
    }

    static void reverse(int[] a, int l, int r) {
        while (l < r) {
            swap(a, l, r);
            l++;
            r--;
        }
    }

    static void mergeSort(int[] a) { //For practice
        int n = a.length;
        if (n < 2) return;
        int[] x = new int[n / 2];
        System.arraycopy(a, 0, x, 0, n / 2);
        int[] y = new int[n - n / 2];
        System.arraycopy(a, n / 2, y, 0, n - n / 2);
        mergeSort(x);
        mergeSort(y);
        merge(a, x, y);
    }

    static void merge(int[] c, int[] a, int[] b) {
        int n = a.length, m = b.length, l = 0, r = 0, j = 0;
        while (l < n && r < m) {
            if (a[l] < b[r]) {
                c[j] = a[l];
                l++;
            } else {
                c[j] = b[r];
                r++;
            }
            j++;
        }
        while (l < n) {
            c[j++] = a[l++];
        }
        while (r < m) {
            c[j++] = b[r++];
        }
    }

    static void move3(int[] a) {
        int n = a.length, l = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                swap(a, i, l);
                l++;
            }
        }
    }

    static void move(int[] a) {
        int n = a.length, l = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                swap(a, i, l);
                l++;
            }
        }
    }

    static void move2(int[] a) {
        int n = a.length, l = 0, r = n - 1;
        while (l < r) {
            if (a[l] < 0) {
                l++;
            } else if (a[r] > 0) {
                r--;
            } else {
                swap(a, l, r);
                l++;
                r--;
            }
        }
    }
}
