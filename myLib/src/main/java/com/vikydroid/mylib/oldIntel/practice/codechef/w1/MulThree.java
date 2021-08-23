package com.vikydroid.mylib.oldIntel.practice.codechef.w1;

import java.math.BigInteger;
import java.util.Scanner;

class MulThree {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int T = scanner.nextInt();
            while (T-- > 0) {
                BigInteger K = scanner.nextBigInteger();
                int d0 = scanner.nextInt();
                int d1 = scanner.nextInt();
                int sum = d0 + d1;
                int digit = sum % 10;
                for (BigInteger i = BigInteger.ONE.add(BigInteger.ONE); i.compareTo(K) < 0; i = i.add(BigInteger.ONE)) {
                    sum += digit;
                    digit = sum % 10;
                }
                if (sum % 3 == 0)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
