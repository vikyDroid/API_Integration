package com.vikydroid.mylib.oldIntel.practice.practice2.templateT;

public class LinkedList<T> {
    public Node<T> head;

    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public int length() {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public void addAfter(T data, T after) {
        Node<T> newNode = new Node<T>(data);
        Node<T> afterNode = findNode(after);
        if (afterNode == null) {
            System.out.println("\nNode not found");
        } else {
            newNode.next = afterNode.next;
            afterNode.next = newNode;
        }

    }

    public Node<T> findNode(T key) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void delete(T key) {
        Node<T> temp = head, prev = null;
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


    public Node<T> getMidNode() {
        Node<T> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public void printAll() {
        Node<T> temp = head;
        if (temp == null) {
            System.out.println("\nList is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
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


//        list.addAfter(33, 60);

        list.printAll();
//        list.reverse();
//        list.head = list.reverseR(list.head);
        list.delete(10);
        System.out.println();
        list.printAll();
//        list.printAll();
    }
}
