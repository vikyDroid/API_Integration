package com.vikydroid.mylib.oldIntel.practice.practice7.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println(longestCommonPrefix(arr, arr.length));
    }

    private static String longestCommonPrefix(String[] arr, int n) {
        StringBuilder sb = new StringBuilder();
        int min = Integer.MAX_VALUE;
        for (String s : arr) {
            min = Math.min(min, s.length());
        }
        int i = 0;
        while (i < min) {
            char c = arr[0].charAt(i);
            for (int j = 0; j < n; j++) {
                if (c != arr[j].charAt(i)) {
                    if (sb.length() == 0) return "-1";
                    return sb.toString();
                }
            }
            sb.append(c);
            i++;
        }
        if (sb.length() == 0) return "-1";
        return sb.toString();
    }
}
