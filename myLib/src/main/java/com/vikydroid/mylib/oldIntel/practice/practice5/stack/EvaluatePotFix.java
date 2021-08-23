package com.vikydroid.mylib.oldIntel.practice.practice5.stack;

public class EvaluatePotFix {
    public static void main(String[] args) {
        String s = "231*+9-";
        System.out.println(evaluate(s));
    }

    private static int evaluate(String s) {
        int l, r;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (!stack.isEmpty()) {
                    r = stack.pop().data;
                    l = stack.pop().data;
                    stack.push(new Node<>(l * r));
                }
            } else if (s.charAt(i) == '+') {
                if (!stack.isEmpty()) {
                    r = stack.pop().data;
                    l = stack.pop().data;
                    stack.push(new Node<>(l + r));
                }
            } else if (s.charAt(i) == '-') {
                if (!stack.isEmpty()) {
                    r = stack.pop().data;
                    l = stack.pop().data;
                    stack.push(new Node<>(l - r));
                }
            } else stack.push(new Node<>((int) s.charAt(i) - '1' + 1));
        }
        return stack.top().data;
    }
}
