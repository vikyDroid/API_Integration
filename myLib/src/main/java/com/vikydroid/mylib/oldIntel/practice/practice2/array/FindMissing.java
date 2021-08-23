package com.vikydroid.mylib.oldIntel.practice.practice2.array;

public class FindMissing {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        System.out.println(new FindMissing().findMissing(arr));
    }

    //O(n)
    public int findMissing(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 1; i <= n + 1; i++) {
            sum += i;
        }
        for (int i = 0; i < n; i++) {
            sum -= arr[i];
        }

        return sum;
    }
}
