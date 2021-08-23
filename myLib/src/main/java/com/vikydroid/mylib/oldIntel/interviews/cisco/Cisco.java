package com.vikydroid.mylib.oldIntel.interviews.cisco;


import java.util.Arrays;

public class Cisco {
    public static void main(String[] args) {
        String s = "i am rahul"; //rahul am i
        char[] chars = s.toCharArray();
        reverse(chars, 0, s.length() - 1);   //luhar5ma8i


        //start = 8+1 = 9
        //end = 8-1 = 7;
        //rahul am
        int n = chars.length, start = 0, end = -1;
        for (int i = 0; i < n; i++) {
            if (chars[i] == ' ') {
                end = i - 1;
                reverse(chars, start, end);
                start = i + 1;
            }
        }
        reverse(chars, start, n - 1);

        System.out.println(new String(chars));
    }

    static void reverse(char[] chars, int l, int r) {
        while (l < r) {
            swap(chars, l, r);
            l++;
            r--;
        }
    }

    static void swap(char[] chars, int l, int r) {
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }

}
