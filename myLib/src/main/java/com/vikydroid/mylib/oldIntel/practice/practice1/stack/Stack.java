package com.vikydroid.mylib.oldIntel.practice.practice1.stack;

import com.vikydroid.mylib.oldIntel.practice.practice1.node.Node;

import java.util.Arrays;

public class Stack {
    Node head;

    void push(int key) {
        Node newNode = new Node(key);
        if (!isEmpty()) {
            newNode.next = head;
        }
        head = newNode;

    }

    int pop() {
        int popped = Integer.MIN_VALUE;
        if (!isEmpty()) {
            popped = head.data;
            head = head.next;
        }
        return popped;
    }

    int peek() {
        if (isEmpty()) return Integer.MIN_VALUE;
        else return head.data;
    }

    boolean isEmpty() {
        if (head == null) {
//            System.out.println("List is empty");
            return true;
        } else return false;
    }

    void printAll() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public boolean isOperator(char c) {
        return (c == '/' || c == '*' || c == '+' || c == '-' || c == '(' || c == ')');
    }

    public int prec(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public String infixToPostFix(String exp) {
        String res = "";
        Stack s = new Stack();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (!isOperator(c)) {
                res += c;
            } else if (c == '(') {
                s.push(c);
            } else if (c == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    res += s.pop();
                }
                s.pop();
            } else {
                while (!s.isEmpty() && prec(c) <= prec((char) s.peek())) {
                    res += s.pop();
                }
                s.push(c);
            }
            while (!s.isEmpty()) {
                res += s.pop();
            }

        }
        return res;
    }

    public void nextGreater(int[] arr) {
        int n = arr.length;
        Stack s = new Stack();
        s.push(arr[0]);
        int element;
        int next;
        for (int i = 1; i < n; i++) {
            next = arr[i];
            if (!s.isEmpty()) {
                element = s.pop();
                while (next > element) {
                    System.out.println(element + " -- " + next);
                    if (s.isEmpty())
                        break;
                    element = s.pop();
                }

                if (element > next)
                    s.push(element);
            }
            s.push(next);
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop() + " -- -1");
        }
    }

    public void nextGreater2(int[] A) {
        int n = A.length;
        Stack s = new Stack();
        s.push(A[0]);
        int element;
        int next;
        for (int i = 1; i < n; i++) {
            next = A[i];
            while (!s.isEmpty() && next > s.peek()) {
                System.out.println(s.pop() + " -- " + next);
            }
            s.push(next);
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop() + " -- -1");
        }
    }

    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.printAll();
        stack.pop();

        stack.push(5);

        System.out.println("");
        stack.printAll();

        stack.pop();
        stack.pop();
        System.out.println();
        stack.printAll();

        System.out.println("\n" + stack.peek());
        System.out.println(stack.isEmpty());

        int[] A = {13, 7, 6, 12};
        System.out.println(Arrays.toString(A));
        new Stack().nextGreater2(A);


    }
}
