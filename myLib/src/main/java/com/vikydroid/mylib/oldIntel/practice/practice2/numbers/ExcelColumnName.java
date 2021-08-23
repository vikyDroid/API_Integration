package com.vikydroid.mylib.oldIntel.practice.practice2.numbers;

public class ExcelColumnName {
    public static void main(String[] args) {
        System.out.println(new ExcelColumnName().excelColumnName(26).reverse());
        System.out.println(new ExcelColumnName().excelColumnName(29).reverse());
        System.out.println(new ExcelColumnName().excelColumnName(51).reverse());
        System.out.println(new ExcelColumnName().excelColumnName(52).reverse());
        System.out.println(new ExcelColumnName().excelColumnName(80).reverse());
        System.out.println(new ExcelColumnName().excelColumnName(676).reverse());
        System.out.println(new ExcelColumnName().excelColumnName(702).reverse());
        System.out.println(new ExcelColumnName().excelColumnName(705).reverse());
    }

    public StringBuilder excelColumnName(int num) {
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            int rem = num % 26;
            if (rem == 0) {
                res.append('Z');
                num = (num / 26) - 1;
            } else {
                res.append((char) (rem - 1 + 'A'));
                num = num / 26;
            }
        }
        return res;
    }
}
