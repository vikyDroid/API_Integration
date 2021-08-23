package com.vikydroid.mylib.oldIntel.practice.practice2.ll;

public class AddTwoNum {

    public Node addTwoNum2(Node head1, Node head2) {
        Node first = head1, second = head2, third = null, head3 = null;
        int sum = 0, carry = 0;
        while (first != null && second != null) {
            sum = (first.data + second.data + carry);
            Node newNode = new Node(sum % 10);
            if (head3 == null) {
                head3 = newNode;
                third = head3;
            } else {
                third.next = newNode;
                third = third.next;
            }
            carry = sum / 10;
            first = first.next;
            second = second.next;
        }
        while (first != null) {
            sum = first.data + carry;
            third.next = new Node(sum % 10);
            carry = sum / 10;
            third = third.next;
            first = first.next;
        }
        while (second != null) {
            sum = (second.data + carry);
            third.next = new Node(sum % 10);
            carry = sum / 10;
            third = third.next;
            second = second.next;
        }
        if (carry > 0) {
            third.next = new Node(carry);
        }
        return head3;
    }

    //Brut Force
    public Node addTwoNum(Node head1, Node head2) {
        Node temp1, head3 = null;
        int num1 = getNumFromLL(head1), num2 = getNumFromLL(head2), num3;
        temp1 = null;
        num3 = num1 + num2;
        while (num3 > 0) {
            Node newNode = new Node(num3 % 10);
            if (head3 == null) {
                head3 = newNode;
                temp1 = head3;
            } else {
                temp1.next = newNode;
                temp1 = temp1.next;
            }
            num3 /= 10;
        }
        return head3;
    }

    public int getNumFromLL(Node head) {
        if (head == null) {
            return 0;
        }
        int num = getNumFromLL(head.next);
        num *= 10;
        return num + head.data;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
//        ll1.addAtEnd(7);
//        ll1.addAtEnd(5);
        ll1.addAtEnd(9);
//        ll1.addAtEnd(4);
//        ll1.addAtEnd(6);
        ll1.printAll();
        System.out.println();
        LinkedList ll2 = new LinkedList();
        ll2.addAtEnd(9);
//        ll2.addAtEnd(4);
        ll2.printAll();
        System.out.println();
        LinkedList ll3 = new LinkedList();
        ll3.head = new AddTwoNum().addTwoNum2(ll1.head, ll2.head);
        ll3.printAll();
    }
}
