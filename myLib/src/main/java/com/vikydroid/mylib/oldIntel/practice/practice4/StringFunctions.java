package com.vikydroid.mylib.oldIntel.practice.practice4;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringFunctions {
    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        String[] strArr = {"apple", "ape", "april"};
        System.out.println(largestPalindrome(str, 0, str.length()));
    }

    private static char firstNonRepeating(String str) {
        int TOTAL_CHARS = 256;
        int[] arr = new int[TOTAL_CHARS];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)] += 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) return (char) i;
        }
        return '|';
    }

    static void groupAnagrams(String[] str) {
        int n = str.length;
        Anagram[] anagram = new Anagram[n];
        Anagram[] anagram2 = new Anagram[n];
        for (int i = 0; i < n; i++) {
            anagram[i] = new Anagram(i, str[i]);
            anagram2[i] = new Anagram(i, str[i]);
        }
        for (int i = 0; i < n; i++) {
            char[] chars = anagram[i].s.toCharArray();
            Arrays.sort(chars);
            anagram[i].s = new String(chars);
        }
        Arrays.sort(anagram);
        for (int i = 0; i < n; i++) {
            System.out.print(anagram2[anagram[i].index].s + " ");
        }
    }

    static class Anagram implements Comparable<Anagram> {
        int index;
        String s;

        public Anagram(int index, String s) {
            this.index = index;
            this.s = s;
        }

        @Override
        public int compareTo(@NotNull Anagram o) {
            return this.s.compareTo(o.s);
        }
    }

    static StringBuilder largestCommonPrefix(String[] strArr) {
        StringBuilder s = new StringBuilder();
        int j = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (j < strArr[i].length()) {
                char c = strArr[0].charAt(j);
                if (strArr[i].charAt(j++) == c) {
                    s.append(c);
                } else break;
            }
        }
        return s;
    }

    //Redo as it is only working for center position
    private static StringBuilder largestPalindrome(String str, int l, int r) {
        int m = r / 2, start = 0, end = 0, k = 1;
        if (r % 2 == 0) {
            k = 0;
            while (l <= k && k < r) {
                if (str.charAt(m - k - 1) == str.charAt(m + k)) {
                    start = m - k - 1;
                    end = m + k;
                    k++;
                } else break;
            }
        } else {
            while (l <= k && k < r) {
                if (str.charAt(m - k) == str.charAt(m + k)) {
                    start = m - k;
                    end = m + k;
                    k++;
                } else break;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = start; i <= end && end > 0; i++) {
            builder.append(str.charAt(i));
        }
        return builder;
    }
}
