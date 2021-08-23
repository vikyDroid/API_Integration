package com.vikydroid.mylib.oldIntel.practice.practice2.ll;

public class NthNodeFromLast {
    public Node getNthNodeFromLast(Node head, int n) {
        if (head == null) return null;
        Node slow = head, fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.printAll();
        System.out.println();
        System.out.println(new NthNodeFromLast().getNthNodeFromLast(list.head, 7));


    }
}
