package com.vikydroid.mylib.oldIntel.practice.practice5.numbers;

public class ExcelColumnTitle {
    public static void main(String[] args) {
//        System.out.println(excelColumnTitle("AY"));
//        System.out.println(excelColumnTitle("AZ"));
//        System.out.println(excelColumnTitle("CB"));
//        System.out.println(excelColumnTitle("YZ"));
//        System.out.println(excelColumnTitle("ZZ"));
//        System.out.println(excelColumnTitle2("AAC"));
        System.out.println(excelColumnTitle2("CDAAAA"));
    }

    //Very Good answer
    private static int excelColumnTitle(String s) {
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int val = s.charAt(i) - 'A' + 1;
            ans += val * Math.pow(26, s.length() - 1 - i);
        }
        return ans;
    }

    private static int excelColumnTitle2(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans *= 26;
            ans += s.charAt(i) - 'A' + 1;
        }
        return ans;
    }
}
