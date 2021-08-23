package com.vikydroid.mylib.oldIntel.practice.codechef.w2;

import java.util.Scanner;
import java.util.Stack;

public class InFixToPost {
    double g= 1e5;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            String s = scanner.next();
            Stack<String> stack = new Stack<>();
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*'
                        || s.charAt(i) == '/' || s.charAt(i) == '^') {
                    temp = new StringBuilder(stack.pop());
                } else if (s.charAt(i) == '(') {
                    stack.push(String.valueOf(s.charAt(i)));
                } else if (s.charAt(i) == ')') {
//                    while (!stack.isEmpty()) {
                        temp = new StringBuilder(stack.pop());
//                    }
                }else {

                }
            }
        }
    }
}
