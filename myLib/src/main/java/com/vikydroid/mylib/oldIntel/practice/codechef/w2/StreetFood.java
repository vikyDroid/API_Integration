package com.vikydroid.mylib.oldIntel.practice.codechef.w2;

import java.util.Scanner;

public class StreetFood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt(), max = 0;
            while (N-- > 0) {
                int S = scanner.nextInt();
                int P = scanner.nextInt();
                int V = scanner.nextInt();
                int profit = (P / (S + 1))* V;
                max = Math.max(max, profit);
            }
            System.out.println(max);
        }
    }
}
