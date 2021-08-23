package com.vikydroid.mylib.oldIntel.practice.practice5.numbers;

public class ExcelColumnNum {
    public static void main(String[] args) {

        System.out.println(excelColumn(26));
        System.out.println(excelColumn(51));
        System.out.println(excelColumn(52));
        System.out.println(excelColumn(80));
        System.out.println(excelColumn(676));
        System.out.println(excelColumn(702));
        System.out.println(excelColumn(705));
    }

    private static String excelColumn(int x) {
        int total = 26;
        if (x > total) {
            if (x % total == 0) {
                return excelColumn((x / total) - 1) + 'Z';
            } else {
                return excelColumn(x / total) + (char) ((x % total) + 'A' - 1);
            }
        } else return String.valueOf((char) (x + 'A' - 1));
    }
}
