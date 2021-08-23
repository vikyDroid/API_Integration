package com.vikydroid.mylib.oldIntel.practice.practice2.ll;

import java.util.Stack;

public class ReverseKSize {


    public Node reverseKSizeR(Node head, int k) {
        Node prev = null, curr = head, next = null;
        int count = 0;
        while (curr != null && count != k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (next != null)
            head.next = reverseKSizeR(next, k);

        return prev;
    }

    //Using Stack
    public Node reverseKSize(Node head, int k) {
        Node curr = head, prev = null;
        Stack<Node> stack = new Stack<>();
        while (curr != null) {
            int count = 0;
            while (curr != null && count < k) {
                stack.push(curr);
                curr = curr.next;
                count++;
            }
            while (!stack.isEmpty()) {
                if (prev == null) {
                    prev = stack.pop();
                    head = prev;
                } else {
                    prev.next = stack.pop();
                    prev = prev.next;
                }
            }
        }
        prev.next = null;
        return head;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.printAll();
        list.head = new ReverseKSize().reverseKSizeR(list.head, 3);
        System.out.println();
        list.printAll();
    }
}
