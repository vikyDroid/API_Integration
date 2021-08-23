package com.vikydroid.mylib.oldIntel.practice.practice7.ll;


import org.jetbrains.annotations.NotNull;

import java.util.Stack;

public class LLOperations {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        for (int i = 1; i <= 14; i++) {
            list1.addAtLast(i);
        }
        Node<Integer> last = list1.head;
        for (int i = 1; i < 14; i++) {
            last = last.next;
        }
        Node<Integer> temp = list1.head;
        for (int i = 1; i <= 3; i++) {
            temp = temp.next;
        }
        last.next = temp;
        System.out.println();

        list1.detectRemoveLoop(list1.head);
        list1.print(list1.head);

    }

    private static Node<Integer> sum(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        Node<Integer> res = null, left = list1.head, right = list2.head;
        int carry = 0;
        while (left != null && right != null) {
            int sum = left.data + right.data + carry;
            carry = sum / 10;
            res = addNode(res, sum % 10);

            left = left.next;
            right = right.next;
        }
        while (left != null) {
            int sum = left.data + carry;
            carry = sum / 10;
            res = addNode(res, sum % 10);
            left = left.next;
        }
        while (right != null) {
            int sum = right.data + carry;
            carry = sum / 10;
            res = addNode(res, sum % 10);
            right = right.next;
        }
        return res;
    }

    @NotNull
    private static Node<Integer> addNode(Node<Integer> res, int data) {
        if (res == null) {
            res = new Node<>(data);
        } else {
            Node<Integer> temp = res;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new Node<>(data);
        }
        return res;
    }

    static Node<Integer> sum2(LinkedList<Integer> list, LinkedList<Integer> list2) {
        Node<Integer> left = list.head, right = list2.head;
        int x = 0, y = 0, sum;
        while (left != null) {
            x *= 10;
            x += left.data;
            left = left.next;
        }
        while (right != null) {
            y *= 10;
            y += right.data;
            right = right.next;
        }

        sum = x + y;
        Node<Integer> res = null;
        while (sum > 0) {
            res = addNode(res, sum % 10);
            sum /= 10;
        }
        return res;
    }

    static Node<Integer> sum3(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        Node<Integer> left = list1.head, right = list2.head;
        Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();
        while (left != null) {
            stack1.push(left.data);
            left = left.next;
        }
        while (right != null) {
            stack2.push(right.data);
            right = right.next;
        }
        int carry = 0;
        Node<Integer> res = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.pop() + stack2.pop() + carry;
            res = addNode2(res, sum % 10);
            carry = sum / 10;
        }
        while (!stack1.isEmpty()) {
            int sum = stack1.pop() + carry;
            res = addNode2(res, sum % 10);
            carry = sum / 10;
        }
        while (!stack2.isEmpty()) {
            int sum = stack2.pop() + carry;
            res = addNode2(res, sum % 10);
            carry = sum / 10;
        }
        return res;
    }

    static Node<Integer> addNode2(Node<Integer> res, int data) {
        Node<Integer> temp = res;
        res = new Node<>(data);
        res.next = temp;
        return res;
    }

    void reArrange(Node<Integer> head) {

    }
}
