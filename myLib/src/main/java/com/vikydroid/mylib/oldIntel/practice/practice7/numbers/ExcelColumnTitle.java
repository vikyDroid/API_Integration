package com.vikydroid.mylib.oldIntel.practice.practice7.numbers;

public class ExcelColumnTitle {
    public static void main(String[] args) {
        String s = "CDA";
        System.out.println(getNum(s));
        System.out.println(getNum2(s));
    }

    private static int getNum(String s) {
        int n = s.length(), i = 0, ans = 0;
        while (i < n) {
            int y = (s.charAt(n - 1 - i) - 'A') + 1;
            int num = (int) Math.pow(26, i);
            ans += num * y;
            i++;
        }
        return ans;
    }

    private static int getNum2(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            res *= 26;
            res += s.charAt(i) - 'A' + 1;
        }
        return res;
    }
}
