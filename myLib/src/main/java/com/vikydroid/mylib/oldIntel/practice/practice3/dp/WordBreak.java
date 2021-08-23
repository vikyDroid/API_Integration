package com.vikydroid.mylib.oldIntel.practice.practice3.dp;

import java.util.*;

public class WordBreak {

    static String[] dict = {"i", "like", "sam", "sung", "samsung", "mobile", "ice",
            "cream", "icecream", "man", "go", "mango"};
    static String str = "ilike";
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Collections.addAll(set, dict);
        System.out.println(isWordBreakableR(str));

        Map<String, Boolean> map = new HashMap<>();
        System.out.println(isWordBreakableMemoization(str, map));
        System.out.println(isWordBreakableDP(str));
        System.out.println(isWordBreakableDP2(str));
    }

    //GFG
    private static boolean isWordBreakableDP2(String s) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!dp[i] && set.contains(s.substring(0, i))) {
                dp[i] = true;
            }
            if (dp[i]) {
                if (i == n)
                    return true;

                for (int j = i + 1; j <= n; j++) {
                    if (!dp[j] && set.contains(s.substring(i, j - i))) {
                        dp[j] = true;
                    }
                    if (j == n && dp[j])
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * https://www.youtube.com/watch?v=hLQYQ4zj0qg
     */
    private static boolean isWordBreakableR(String s) {
        if (s.equals("")) return true;
        for (int i = 1; i <= s.length(); i++) {
            if (set.contains(s.substring(0, i)) && isWordBreakableR(s.substring(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * https://www.youtube.com/watch?v=hLQYQ4zj0qg
     */
    private static boolean isWordBreakableMemoization(String s, Map<String, Boolean> map) {
        if (s.equals("")) {
            return true;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 1; i <= s.length(); i++) {
            if (set.contains(s.substring(0, i)) && isWordBreakableR(s.substring(i))) {
                map.put(s.substring(i), true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }

    /**
     * https://www.youtube.com/watch?v=hLQYQ4zj0qg
     */
    //Most Efficient
    private static boolean isWordBreakableDP(String s) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }


    //WRONG as usual In followed Tushar Roy
    private static boolean isWordBreakable(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (set.contains(s.substring(i, i + j))) {
                    dp[i][j] = true;
                    continue;
                }
                for (int k = i + 1; k <= j; k++) {
                    if (dp[i][k - 1] && dp[k][j]) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
