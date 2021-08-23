package com.vikydroid.mylib.oldIntel.practice.practice2.array;

import java.util.Arrays;

//Find duplicate within range 0 to n-1
public class FindDuplicateInPlace {
    public static void main(String[] args) {
        int[] arr = {0, 3, 4, 3, 4};
        new FindDuplicateInPlace().findDuplicate1(arr);
        System.out.println();
//        new FindDuplicateInPlace().findDuplicate2(arr);
//        System.out.println();
        new FindDuplicateInPlace().findDuplicate3(arr);
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    //BEST handles 0 and more than 2 repeating as well
    public void findDuplicated3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[arr[i] % arr.length] = arr[arr[i] % arr.length] + arr.length;
        }
        System.out.println("The repeating elements are : ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= arr.length * 2) {
                System.out.print(i + " ");
            }
        }
    }

    //Time = O(n) In Place
    public void findDuplicate2(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[Math.abs(arr[i])] > 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            } else {
                System.out.print(Math.abs(arr[i]) + " ");
            }
        }
    }


    //Time = O(n) Handling zeroes
    public void findDuplicate3(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[arr[i] % n] += n;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] >= n * 2) {
                System.out.print(i + " ");
            }
        }
    }

    //Not Good Time = O(n), Space = O(n) via array
    public void findDuplicate1(int[] arr) {
        int n = arr.length;
        int[] count = new int[n];
        for (int value : arr) {
            if (count[value] == 1) {
                System.out.print(value + " ");
            } else {
                count[value] = 1;
            }
        }
    }
}
