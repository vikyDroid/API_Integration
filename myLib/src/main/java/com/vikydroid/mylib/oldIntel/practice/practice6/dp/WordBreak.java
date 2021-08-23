package com.vikydroid.mylib.oldIntel.practice.practice6.dp;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    static String[] dict = {"mobile", "samsung", "sam", "sung",
            "man", "mango", "icecream", "and",
            "go", "i", "like", "ice", "cream"};
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Collections.addAll(set, dict);
        System.out.println(wordBreakT("ilike"));
        System.out.println(wordBreakT("ilikesamsung"));
        System.out.println(wordBreakT("iiiiiiii"));
        System.out.println(wordBreakT(""));
        System.out.println(wordBreakT("ilikelikeimangoiii"));
        System.out.println(wordBreakT("samsungandmango"));
        System.out.println(wordBreakT("samsungandmangok"));
    }

    private static boolean wordBreak(String s) {
        int n = s.length();
        if (n == 0)
            return true;
        for (int i = 1; i <= n; i++) {
            if (set.contains(s.substring(0, i)) && wordBreak(s.substring(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean wordBreakT(String s) {
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

}
