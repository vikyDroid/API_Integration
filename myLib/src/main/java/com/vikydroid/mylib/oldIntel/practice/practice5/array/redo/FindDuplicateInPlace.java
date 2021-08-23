package com.vikydroid.mylib.oldIntel.practice.practice5.array.redo;

public class FindDuplicateInPlace {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};

        //but won't work for negative values
        for (int i = 0; i < arr.length; i++) {
            if (arr[Math.abs(arr[i])] < 0) {
                System.out.println(Math.abs(arr[i]) + " ");
            } else arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
        }

        System.out.println("-----------------");
        arr = new int[]{1, 2, 3, 4, 3};

        findDuplicateInPlace(arr);

    }

    static void findDuplicateInPlace(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[arr[i] % n] += n;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] >= n * 2) System.out.println(i);
        }
    }
}
