package com.vikydroid.mylib.oldIntel.practice.practice2.string;

public class LargestCommonPrefix {
    public static void main(String[] args) {
        String[] strArr = {"geeksforgeeks", "geeks"};
        System.out.println(new LargestCommonPrefix().largestCommonPrefix(strArr));
    }

    public String largestCommonPrefix(String[] strArr) {
        int n = strArr.length;
        String res = "";
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minLength = Math.min(minLength, strArr[i].length());
        }
        for (int j = 0; j < minLength; j++) {
            char c = strArr[0].charAt(j);
            for (int i = 0; i < n; i++) {
                if (c != strArr[i].charAt(j)) {
                    return res;
                }
            }
            res = res.concat(String.valueOf(c));
        }
        return res;
    }
}
