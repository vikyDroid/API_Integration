package com.vikydroid.mylib.oldIntel.practice.practice2.ll;

public class LinkedList {
    Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addAfter(int data, int after) {
        Node newNode = new Node(data);
        Node afterNode = findNode(after);
        if (afterNode == null) {
            System.out.println("\nNode not found");
        } else {
            newNode.next = afterNode.next;
            afterNode.next = newNode;
        }

    }

    public Node findNode(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void delete(int key) {
        Node temp = head, prev = null;
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("\nKey not Found");
        } else {
            prev.next = temp.next;
        }
    }


    public Node getMidNode() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public void printAll() {
        Node temp = head;
        if (temp == null) {
            System.out.println("\nList is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

    }

    public void reverse() {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //via recursion
    public Node reverseR(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node rest = reverseR(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public Node reverse(Node head) {
        Node prev = null, curr = head, start = head;
//        while (curr != null) {
        int count = 0;
        while (count < 3 && curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count++;
        }
        start.next = reverse(curr);
//        }
        return prev;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
//        list.add(10);
//        list.add(60);
//        list.add(30);
//        list.add(20);
//        list.add(80);
//        list.add(40);

        list.addAtEnd(10);
        list.addAtEnd(20);
        list.addAtEnd(30);
        list.addAtEnd(20);
        list.addAtEnd(10);

//        list.delete(10);

//        list.addAfter(33, 60);

        list.printAll();
//        list.reverse();
//        list.head = list.reverseR(list.head);
        System.out.println();
        list.printAll();
//        list.printAll();

    }
}
