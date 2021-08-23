package com.vikydroid.mylib.oldIntel.practice.practice5.str.wrong;

public class LongestPalindromic {
    public static void main(String[] args) {
        String s = "Geekees";
        String s1 = "", s2;
        for (int i = 1; i < s.length(); i++) {
            s2 = longestPalindromic(s.substring(0, i), i - 1);
            if (s2.length() > s1.length()) {
//                s1 = s2;
            }
            System.out.println(s2);
        }
//        System.out.println(longestPalindromic(s));
    }

    private static String longestPalindromic(String s, int mid) {
        int l, r;
        l = mid - 1;
        String ans = "";
        if (s.length() % 2 == 0) {
            r = mid;
        } else {
            ans += s.charAt(mid);
            r = mid + 1;
        }
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                ans = s.charAt(l) + ans + s.charAt(l);
                l--;
                r++;
            } else return ans;
        }
        return ans;
    }

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
