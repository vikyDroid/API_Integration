package com.vikydroid.mylib.oldIntel.practice.practice7.string;

public class LPS {
    public static void main(String[] args) {
        String s = "forgeeksskeegfor";
        System.out.println(lps(s));
    }

    private static String lps(String s) {
        int max = Integer.MIN_VALUE;
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            String res = getMaxLPS(s.substring(i));
            if (max < res.length()) {
                max = res.length();
                ans = res;
            }
            res = getMaxLPS(s.substring(0, n - i));
            if (max < res.length()) {
                max = res.length();
                ans = res;
            }
        }
        return ans;
    }

    private static String getMaxLPS(String s) {
        String res = "";
        int n = s.length(), l, r, mid = n / 2;
        l = mid - 1;
        if (n % 2 == 0) {
            r = mid;
        } else {
            res += s.charAt(mid);
            r = mid + 1;
        }
        while (l >= 0 && r < n) {
            if (s.charAt(l) == s.charAt(r)) {
                res = s.charAt(l) + res + s.charAt(r);
                l--;
                r++;
            } else {
                break;
            }
        }
        return res;
    }
}
