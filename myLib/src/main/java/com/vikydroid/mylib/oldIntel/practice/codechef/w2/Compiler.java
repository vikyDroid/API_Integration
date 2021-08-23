package com.vikydroid.mylib.oldIntel.practice.codechef.w2;

import java.util.Scanner;
import java.util.Stack;

public class Compiler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            String s = scanner.next();
            Stack<Character> stack = new Stack<>();
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (stack.isEmpty()) {
                    stack.push(s.charAt(i));
                } else if (stack.peek() == '<' && s.charAt(i) == '>') {
                    stack.pop();
                    count += 2;
                } else stack.push(s.charAt(i));
            }
            System.out.println(count);
        }
    }
}
