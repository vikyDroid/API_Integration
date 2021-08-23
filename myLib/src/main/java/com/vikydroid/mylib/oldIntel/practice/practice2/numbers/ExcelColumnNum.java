package com.vikydroid.mylib.oldIntel.practice.practice2.numbers;

public class ExcelColumnNum {
    public static void main(String[] args) {
        String str = "ZZ";
        System.out.println("Ans : " + new ExcelColumnNum().excelColumnNum(str));
        System.out.println("Ans : " + new ExcelColumnNum().excelColumnNum2(str));
    }

    //Efficient
    public int excelColumnNum(String str) {
        int n = str.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            res *= 26;
            res += str.charAt(i) - 'A' + 1;
        }
        return res;
    }

    //my approach
    public int excelColumnNum2(String str) {
        int n = str.length();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == 'Z') {
                s.append("0");
            } else {
                s.append(c - 'A' + 1);
            }
        }
        System.out.println(s);
        int n1 = s.length();
        int i;
        int ans = 0;
        for (i = 0; i < n1 - 1; i++) {
            int val = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (val == 0) {
                ans = (ans + 26) * 26;
            } else {
                ans = (ans + val) * 26;
            }

        }

        int val = Integer.parseInt(String.valueOf(s.charAt(i)));
        if (val == 0) {
            ans += 26;
        } else {
            ans += val;
        }
        return ans;
    }

}
