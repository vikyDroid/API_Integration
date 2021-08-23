package com.vikydroid.mylib.oldIntel.practice.practice5.str;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"apple", "ape", "april"};
        int minIndex = Integer.MAX_VALUE;
        for (String s : arr) {
            minIndex = Math.min(minIndex, s.length());
        }
        int j = 0;
        while (j < minIndex) {
            char c = arr[0].charAt(j);
            for (int i = 0; i < arr.length; i++) {
                if (c == arr[i].charAt(j)) {
                    if (i == arr.length - 1) System.out.print(c);
                } else return;
            }
            j++;
        }
    }
}
