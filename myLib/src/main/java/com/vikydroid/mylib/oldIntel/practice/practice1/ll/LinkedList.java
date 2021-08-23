package com.vikydroid.mylib.oldIntel.practice.practice1.ll;

import com.vikydroid.mylib.oldIntel.practice.practice1.node.Node;

public class LinkedList {
    public Node head;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    /*public void push2(int data) {
        head = new Node(data);
    }*/

    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    void insertAfter(Node previousNode, int data) {
        if (previousNode == null) {
            System.out.println("Previous node can not be null");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = previousNode.next;
        previousNode.next = newNode;
    }

    void insertAfter(int afterThis, int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == afterThis) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            } else temp = temp.next;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }

    void printListCircular() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
        }

    }

    void deleteNode(int key) {
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
            System.out.println("Key Not Present");
            return;
        }
        prev.next = temp.next;

    }

    public Node findNthFromEnd(Node head, int n) {
        Node one = head, two = head;
        int count = 0;
        while (count < n) {
            if (two == null) {
                System.out.println(n + " is greater than the size of list");
                break;
            }
            count++;
            two = two.next;
        }
        while (two != null) {
            one = one.next;
            two = two.next;
        }
        return one;
    }

    int count = 0;

    public int getCountOfRepetition(Node head, int key) {
        Node temp = head;
        if (temp == null)
            return count;
        if (temp.data == key) {
            count++;
        }
        return getCountOfRepetition(temp.next, key);
    }

    public boolean isPalindrome(Node head) {
        Node midNode = getMidNode(head);
        Node first = head;
        Node second = midNode;
        while (second != null) {
            if (first.data != second.data) {
                return false;
            }
        }
        return true;
    }

    public Node reverse(Node head) {
        Node previous = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }

    public Node reverseByRecursion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node rest = reverseByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public Node reverseByRecursion2(Node curr, Node prev) {
        Node head = null;
        if (curr.next == null) {
            head = curr;
            curr.next = prev;
            return head;
        }
        Node saved = curr.next;
        curr.next = prev;
        reverseByRecursion2(saved, curr);
        return head;
    }

    public void swap(Node head, int x, int y) {
        Node xCurr = head, yCurr = head, xPrev = null, yPrev = null;
        while (xCurr != null && xCurr.data != x) {
            xPrev = xCurr;
            xCurr = xCurr.next;
        }
        while (yCurr != null && yCurr.data != y) {
            yPrev = yCurr;
            yCurr = yCurr.next;
        }

        if (xPrev != null) {
            xPrev.next = yCurr;
        } else
            head = yCurr;

        if (yPrev != null) {
            yPrev.next = xCurr;
        } else
            head = xCurr;

        Node temp = yCurr.next;
        yCurr.next = xCurr.next;
        xCurr.next = temp;
    }

    private Node getMidNode(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node evenOddSegregate(Node head) {
        Node evenEnd = null, oddEnd = null, currentNode = head, evenStart = null, oddStart = null;
        while (currentNode != null) {
            if (currentNode.data % 2 == 0) {
                if (evenEnd == null) {
                    evenStart = currentNode;
                    evenEnd = currentNode;
                } else {
                    evenEnd.next = currentNode;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddEnd == null) {
                    oddStart = currentNode;
                    oddEnd = currentNode;
                } else {
                    oddEnd.next = currentNode;
                    oddEnd = oddEnd.next;
                }
            }
            currentNode = currentNode.next;
        }
        evenEnd.next = oddStart;
        oddEnd.next = null;

        return evenStart;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(1);
        linkedList.append(2);
        linkedList.append(30);
        linkedList.insertAfter(linkedList.head, 3);
        linkedList.insertAfter(linkedList.head, 40);
        linkedList.insertAfter(1, 6);
        linkedList.insertAfter(30, 36);
        linkedList.push(4);
        linkedList.push(5);
        linkedList.printList();

        linkedList.deleteNode(3);

        System.out.println("\n");
        linkedList.printList();
    }

}


