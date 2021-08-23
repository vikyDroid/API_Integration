package com.vikydroid.mylib.oldIntel.practice.practice7.string;

public class FirstNonRepeating {
    public static void main(String[] args) {
        String s = "GeeksforGeeks";
        System.out.println(firstNonRepeatingChar(s));
    }

    private static char firstNonRepeatingChar(String s) {
        int n = s.length(), size = 256;
        char c;
        int[] arr = new int[size];
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i)]++;
        }
        for (int i = 0; i < size; i++) {
            if (arr[i] == 1) {
                return (char) i;
            }
        }
        return '$';
    }
}
