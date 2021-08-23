package com.vikydroid.mylib.oldIntel.practice.practice2.string;

public class LongestPalindromic {
    public static void main(String[] args) {
        String str = "gggggggeekkeeggfdsfdsf";
        System.out.println(new LongestPalindromic().longestPalindromic(str));
    }

    public int longestPalindromic(String str) {
        int maxLength = 1; // The result (length of LPS)

        int start = 0;
        int len = str.length();

        int low, high;

        // One by one consider every character as center
        // point of even and length palindromes
        for (int i = 1; i < len; ++i) {
            // Find the longest even length palindrome with
            // center points as i-1 and i.
            low = i - 1;
            high = i;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }

            // Find the longest odd length palindrome with
            // center point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        System.out.println("Longest palindrome substring is: " +
                str.substring(start, start + maxLength));

        return maxLength;
    }

    public String longestPalindromicMineWrong(String str) {
        int n = str.length();
        String res = "";
        int mirrorIndex = 0;
        int mid = n / 2;
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                if (Math.abs(mid - mirrorIndex) > Math.abs(mid - i))
                    mirrorIndex = i;
            }
        }
        for (int i = mirrorIndex, j = mirrorIndex + 1; i > 0 && j < n; i--, j++) {
            if (str.charAt(i) != str.charAt(j)) {
                return res;
            }
            res = str.charAt(i) + res + str.charAt(j);
        }
        return res;
    }
}
