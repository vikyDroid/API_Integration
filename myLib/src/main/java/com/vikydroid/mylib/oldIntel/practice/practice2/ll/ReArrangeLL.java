package com.vikydroid.mylib.oldIntel.practice.practice2.ll;

public class ReArrangeLL {
    public void reArrangeLL(Node head) {
        Node curr = head, end = head;
        while (curr != null) {
            curr.next = getLast(curr);
            curr = curr.next.next;
        }
    }

    public void reArrangeLLR(Node head, Node last) {
        if (last == null) {
            return;
        }
        reArrangeLLR(head, last.next);

        if (head != last && head.next != last) {
            Node temp = head.next;
            head.next = last;
            last.next = temp;
            head = temp;
        } else {
            if (head != last) {
                head = head.next;
                head.next = null;
            }
        }
        return;

    }

    //Create a node and append
    public Node reArrangeLL(Node head1, Node head2) {
        Node left = head1, right = head2, curr = new Node(0);
        while (left != null && right != null) {
            if (left != null) {
                curr.next = left;
                curr = curr.next;
                left = left.next;
            }
            if (right != null) {
                curr.next = right;
                curr = curr.next;
                right = right.next;

            }
        }
        return curr.next;
    }

    private Node getLast(Node head) {
        Node last = head, prev = null;
        while (last.next != null) {
            prev = last;
            last = last.next;
        }
        prev.next = null;
        return last;
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
        new ReArrangeLL().reArrangeLL(list.head);
        list.printAll();


    }
}
