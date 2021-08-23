package com.vikydroid.mylib.oldIntel.practice.practice5.stack;

public class BalancedParenthesis {
    public static void main(String[] args) {
        String s = "[()]{}{[()()]()}";
        System.out.println(isBalanced(s));
    }

    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                if (!stack.isEmpty() && stack.top().data == '[') {
                    stack.pop();
                }
            } else if (!stack.isEmpty() && s.charAt(i) == '}') {
                if (stack.top().data == '{') {
                    stack.pop();
                }
            } else if (!stack.isEmpty() && s.charAt(i) == ')') {
                if (stack.top().data == '(') {
                    stack.pop();
                }
            } else stack.push(new Node<>(s.charAt(i)));
        }
        return stack.isEmpty();
    }
}
