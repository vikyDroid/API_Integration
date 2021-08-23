package com.vikydroid.mylib.oldIntel.practice.practice4;

import com.practice.practice.practice2.templateT.LinkedList;
import com.practice.practice.practice2.templateT.Node;

public class LlFunctions {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(4);
        list.add(1);
        list.add(2);
//        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);
        list.printAll();
        System.out.println();
//        LinkedList<Integer> list1 = new LinkedList<>();
//        list1.head = reverseLl(list.head);
//        list1.printAll();
        System.out.println(isPalindrome(list.head));
        list.printAll();
        System.out.println();
    }

    private static Node<Integer> reverseLl(Node<Integer> head) {
        Node<Integer> prev = null, next = null, curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //Only saving older order not working
    static boolean isPalindrome(Node<Integer> head) {
        Node<Integer> midNode = null, left = head, right = null, prev = null;
        Node<Integer> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        midNode = slow;
        if (prev != null) {
            prev.next = null;
        }
        if (fast == null) {
            right = reverseLl(midNode);
        } else {
            right = reverseLl(midNode.next);
        }
        while (left != null && right != null) {
            if (!left.data.equals(right.data)) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        //Saving older oreder
        if (prev != null) {
            prev.next = slow;
        }
        if (fast == null) {
            reverseLl(midNode);
        } else {
            reverseLl(midNode.next);
        }
        return true;
    }

    private static Node<Integer> getMidNode(Node<Integer> head) {
        Node<Integer> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
