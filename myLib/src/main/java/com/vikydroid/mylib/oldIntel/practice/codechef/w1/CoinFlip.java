package com.vikydroid.mylib.oldIntel.practice.codechef.w1;

import java.util.Arrays;
import java.util.Scanner;

class CoinFlip {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int T = scanner.nextInt();
            while (T-- > 0) {
                int G = scanner.nextInt();
                while (G-- > 0) {
                    int I = scanner.nextInt();
                    int N = scanner.nextInt();
                    int Q = scanner.nextInt();

                    boolean[] arr = new boolean[N];
                    if (I == 1) Arrays.fill(arr, true);
                    for (int i = 0; i < N; i++) {
                        if ((N - i) % 2 == 1)
                            arr[i] = !arr[i];
                    }
                    int countHeads = 0;
                    for (int i = 0; i < N; i++) {
                        if (arr[i]) countHeads++;
                    }
                    if (Q == 1) System.out.println(countHeads);
                    else System.out.println(N - countHeads);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
