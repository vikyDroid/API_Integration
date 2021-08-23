package com.vikydroid.mylib.oldIntel.practice.practice2.numbers;

public class PalindromeNum {
    public static void main(String[] args) {
        System.out.println(new PalindromeNum().isPalindrome(1242));
        System.out.println(new PalindromeNum().isPalindrome(1231));
        System.out.println(new PalindromeNum().isPalindrome(12));
        System.out.println(new PalindromeNum().isPalindrome(88));
        System.out.println(new PalindromeNum().isPalindrome(8999));
        System.out.println(new PalindromeNum().isPalindrome(1001));
    }

    public boolean isPalindrome(int num) {
        int res = 0, temp = num;
        while (temp > 0) {
            res *= 10;
            res += temp % 10;
            temp = temp / 10;
        }
        return res == num;
    }
}
