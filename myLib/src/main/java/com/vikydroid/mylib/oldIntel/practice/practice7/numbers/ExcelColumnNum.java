package com.vikydroid.mylib.oldIntel.practice.practice7.numbers;

public class ExcelColumnNum {
    public static void main(String[] args) {
//        int n = 27;
//        System.out.println(getTitle(26));
//        System.out.println(getTitle(51));
        System.out.println(getTitle(52));
//        System.out.println(getTitle(80));
        System.out.println(getTitle(676));
//        System.out.println(getTitle(702));
        System.out.println(getTitle(705));
    }

    private static String getTitle(int n) {
        StringBuilder s = new StringBuilder();
        int x = 26;
        while (n > 0) {
            int rem = n % x;
            n = n / x;
            if (rem == 0) {
                s.insert(0, 'Z');
                n--;
            } else {
                s.insert(0, (char) (rem + 'A' - 1));
            }
        }
        return s.toString();
    }
}
