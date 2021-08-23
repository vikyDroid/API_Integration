package com.vikydroid.mylib.oldIntel.practice.practice3.dp;

import java.util.Arrays;

//https://www.youtube.com/watch?v=qli-JCrSwuk&t=16s
public class DecodeMessage {
    public static void main(String[] args) {
        String s = "";
        System.out.println(maxWaysR(s, s.length()));

        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        System.out.println(maxWaysMemoization(s, s.length(), memo));
        System.out.println(maxWaysDP(s));
    }

    private static int maxWaysR(String s, int n) {
        if (n == 0) return 1;
        if (s.charAt(s.length() - n) == '0') return 0;//seems a wrong line
        if (s.equals("")) return 1;
        int res = maxWaysR(s, n - 1);
        int beginIndex = s.length() - n;
        int endIndex = beginIndex + 2;
        if (/*n <= 2*/ endIndex <= s.length() &&
                Integer.parseInt(s.substring(beginIndex, endIndex)) <= 26) {
            res += maxWaysR(s, n - 2);
        }
        return res;
    }

    private static int maxWaysMemoization(String s, int n, int[] memo) {
        if (n == 0) {
            return 1;
        }
        if (s.charAt(s.length() - n) == '0') {
            return 0;
        }
        if (s.equals("")) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        int res = maxWaysMemoization(s, n - 1, memo);
        int beginIndex = s.length() - n;
        int endIndex = beginIndex + 2;
        if (/*n <= 2*/endIndex <= s.length() &&
                Integer.parseInt(s.substring(beginIndex, endIndex)) <= 26) {
            res += maxWaysMemoization(s, n - 2, memo);
        }
        memo[n] = res;
        return res;
    }

    //It's correct but Need to recheck for all cases
    private static int maxWaysDP(String s) {
        int n = s.length();
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) > '0') {
                dp[i] = dp[i - 1];
            }
            String substring = s.substring(i);
            if (substring.length() == 0 || Integer.parseInt(substring) <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
