package com.vikydroid.mylib.oldIntel.practice.practice2.stack;

import com.vikydroid.mylib.oldIntel.practice.practice2.templateT.Stack;

public class EvaluatePostfix {
    public int evaluatePostfix(String exp) {
        int n = exp.length(), val = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            char c = exp.charAt(i);
            if (isNum(c)) {
                stack.push(Integer.parseInt("" + c));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (c) {
                    case '+':
                        val = a + b;
                        break;
                    case '-':
                        val = a - b;
                        break;
                    case '*':
                        val = a * b;
                        break;
                    case '/':
                        val = a / b;
                        break;
                }
                stack.push(val);
            }
        }
        return val;
    }

    private char getSign(char c) {
        if (!isNum(c)) {
            return c;
        } else {
            return 0;
        }
    }

    private boolean isNum(char c) {
        return !(c == '+' || c == '-' || c == '*' || c == '/');
    }

    public static void main(String[] args) {
        String exp = "231*+9-";
        System.out.println(new EvaluatePostfix().evaluatePostfix(exp));
        Character.isDigit('c');
    }
}
