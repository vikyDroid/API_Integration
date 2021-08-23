package com.vikydroid.mylib.oldIntel.practice.practice4.dp;

import java.util.Arrays;
import java.util.HashMap;

public class DecodeMessage {
    public static void main(String[] args) {
        String s = "1234";
        int n = s.length();
        System.out.println(waysR(s.toCharArray(), n));
        HashMap<String, Integer> memo = new HashMap<>();
        System.out.println(waysMemo(s.toCharArray(), n, memo));
        System.out.println(waysDP(s.toCharArray()));
    }

    private static int waysR(char[] chars, int n) {
        if (n == 0 || n == 1) return 1;
        if (chars[n - 1] == '0') return 0;
        int count = 0;
        if (chars[n - 1] > '0') {
            count = waysR(chars, n - 1);
        }
        if ((chars[n - 2] == '1') ||
                (chars[n - 2] == '2' && chars[n - 1] < '7')) {
            count += waysR(chars, n - 2);
        }
        return count;
    }

    private static int waysMemo(char[] chars, int n, HashMap<String, Integer> memo) {
        if (n == 0 || n == 1) return 1;
        if (chars[n - 1] == '0') return 0;
        String key = Arrays.toString(chars).substring(0, n);
        if (memo.containsKey(key))
            return memo.get(key);
        int count = 0;
        if (chars[n - 1] > '0') {
            count = waysR(chars, n - 1);
        }
        if ((chars[n - 2] == '1') ||
                (chars[n - 2] == '2' && chars[n - 1] < '7')) {
            count += waysR(chars, n - 2);
        }
        memo.put(key, count);
        return count;
    }

    private static int waysDP(char[] chars) {
        int n = chars.length;
        if (n == 0 || n == 1) return 1;
        if (chars[0] == '0') return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (chars[i - 1] > '0') {
                dp[i] = dp[i - 1];
            }
            if (chars[i - 2] == '1' ||
                    (chars[i - 2] == '2' && chars[i - 1] < '7')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    //Wrong
    private static int waysR(String s, int n) {
        if (n == 0) return 1;
        if (n > 1) {
            String substring = s.substring(n - 2);
            int val2 = Integer.parseInt(substring);
            if (val2 > 0 && val2 < 27) {
                return 1 + waysR(substring, substring.length());
            }
        }
        if (n > 0) {
            String substring = s.substring(n - 1);
            int val1 = Integer.parseInt(substring);
            if (val1 > 0 && val1 < 10) {
                return 1 + waysR(substring, substring.length());
            }
        }
        return 0;
    }

}
