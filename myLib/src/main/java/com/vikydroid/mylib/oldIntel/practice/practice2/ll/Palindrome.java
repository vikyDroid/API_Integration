package com.vikydroid.mylib.oldIntel.practice.practice2.ll;

public class Palindrome {
    public boolean isPalindrome(Node head) {
        boolean isPal = true;
        if (head != null && head.next != null) {
            Node slow = head, fast = head,
                    midNode = null, prevOfSlow = null;
            while (fast != null && fast.next != null) {
                prevOfSlow = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            if (fast != null) {   //LL is Odd
                midNode = slow;
                slow = slow.next;
            }
            slow = reverse(slow);
            prevOfSlow.next = null;
            Node temp1 = head, temp2 = slow;
            while (temp1 != null && temp2 != null) {
                if (temp1.data == temp2.data) {
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                } else {
                    isPal = false;
                    break;
                }
            }
            slow = reverse(slow);
            if (midNode != null) {   //LL is Odd
                prevOfSlow.next = midNode;
            } else prevOfSlow.next = slow;
        }
        return isPal;
    }

    private Node reverse(Node head) {
        Node prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    public boolean isPalindromeR(Node right) {
        left = list.head;

        if (right == null) return true;

        boolean isP = isPalindromeR(right.next);

        if (isP == false) return false;
        boolean b = left.data == right.data;
        if (b) {
            left = left.next;
        }
        return b;
    }

    static LinkedList list = new LinkedList();
    Node left;

    public static void main(String[] args) {
        list.add(5);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(20);
        list.add(10);
        list.add(5);
        list.printAll();
        System.out.println("\n" + new Palindrome().isPalindromeR(list.head));
        list.printAll();
    }
}
