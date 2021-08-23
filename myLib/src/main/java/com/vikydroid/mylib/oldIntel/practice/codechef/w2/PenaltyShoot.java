package com.vikydroid.mylib.oldIntel.practice.codechef.w2;

import java.util.Scanner;

public class PenaltyShoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            String s = scanner.next();
            int AG = 0, BG = 0, AR = N, BR = N;
            for (int i = 0; i < 2 * N; i++) {
                int k = Integer.parseInt(String.valueOf(s.charAt(i)));
                if (i % 2 == 0) {
                    AG += k;
                    AR--;
                } else {
                    BG += k;
                    BR--;
                }
                if (AG > BR && AG > BG) {
                    System.out.println(i + 1);
                    break;
                } else if (BG > AR && BG > AG) {
                    System.out.println(i + 1);
                    break;
                } else if (AG - BG > AR) {
                    System.out.println(i + 1);
                    break;
                } else if (BG - AG > AR) {
                    System.out.println(i + 1);
                    break;
                } else if (i == 2 * N - 1) {
                    System.out.println(i + 1);
                }
            }
        }
    }
}
