package com.vikydroid.mylib.oldIntel.interviews.grab;

public class GrabN {
    public static void main(String[] args) {
        int[] a = {2, 3, 7, 1};
        int k = 4;
        System.out.println(find(a, k));
    }

    static boolean find(int[] a, int k) {
        int l = 0, n = a.length;
        int r = a.length - 1;
        int e = findPivot(a, l, r);
        int s = e + 1;
        while (s != e) {
            int sum = a[s] + a[e];
            if (sum == k) return true;
            else if (sum < k) {
                s++;
                if (s > r) {
                    s = s % n;
                }
            } else {
                e--;
                if (e <= 0) {
                    e = Math.abs(e % n);
                }
            }
        }
        return false;
    }

    static int findPivot(int[] a, int l, int r) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid - 1 >= l && a[mid] < a[mid - 1]) {
                return mid - 1;
            } else if (mid + 1 <= r && a[mid] > a[mid + 1]) {
                return mid;
            } else if (a[mid] > a[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
