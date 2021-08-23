package com.vikydroid.mylib.oldIntel.practice.codechef.w2;

import java.util.Scanner;

public class StupidMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            int L = 0, min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                min = Math.min(min, arr[i]);
                L += min;
            }
            System.out.println(L);
        }
    }
}
