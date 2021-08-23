package com.vikydroid.mylib.oldIntel.practice.practice2.stack;

public class BalancedParenthesis {
    public boolean isBalancedParenthesis(String exp) {
        int n = exp.length();
        Stack stack = new Stack();
        for (int i = 0; i < n; i++) {
            char c = exp.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (isClosingParenthesis(stack.top(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    boolean isClosingParenthesis(int a, int b) {
        return (a == '[' && b == ']')
                || (a == '{' && b == '}')
                || (a == '(' && b == ')');
    }

    public static void main(String[] args) {
        String exp = "[()]{}{[()()]()}";
//        String exp = "[(])";
        System.out.println(new BalancedParenthesis().isBalancedParenthesis(exp));
    }
}
