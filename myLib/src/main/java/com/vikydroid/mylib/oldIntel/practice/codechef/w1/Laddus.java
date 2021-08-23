package com.vikydroid.mylib.oldIntel.practice.codechef.w1;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

class Laddus {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int T = scanner.nextInt();
            while (T-- > 0) {
                int laddus = 0;
                int activities = scanner.nextInt();
                String origin = scanner.next();

                for (int i = 0; i < activities; i++) {
                    String contestWin = scanner.next();
                    if (contestWin.equals("CONTEST_WON")) {
                        int rank = scanner.nextInt();
                        int bonus = 0;
                        if (rank < 20)
                            bonus = 20 - rank;
                        laddus += 300 + bonus;
                    } else if (contestWin.equals("TOP_CONTRIBUTOR")) {
                        laddus += 300;
                    } else if (contestWin.equals("BUG_FOUND")) {
                        int severity = scanner.nextInt();
                        laddus += severity;
                    } else if (contestWin.equals("CONTEST_HOSTED")) {
                        laddus += 50;
                    } else {
                        assert false;
                    }
                }

                if (origin.equals("INDIAN")) {
                    System.out.println(laddus / 200);
                } else System.out.println(laddus / 400);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
