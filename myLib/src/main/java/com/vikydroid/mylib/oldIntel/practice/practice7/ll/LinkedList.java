package com.vikydroid.mylib.oldIntel.practice.practice7.ll;

public class LinkedList<T> {
    Node<T> head;

    void addAtLast(T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node<T>(data);
        }
    }

    void addAtStart(T data) {
        Node<T> temp = head;
        head = new Node<T>(data);
        head.next = temp;
    }

    Node<T> reverse(Node<T> head) {
        Node<T> prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    Node<T> reverseK(Node<T> head, int k) {
        if (head == null) return null;
        Node<T> prev = null, curr = head, next = null;
        for (int i = 0; i < k && curr != null; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = reverseK(next, k);
        return prev;
    }

    Node<T> reverseR(Node<T> head) {
        if (head == null || head.next == null)
            return head;

        Node<T> last = reverseR(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    void print(Node<T> head) {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.print("NULL");
    }

    public boolean isPalindrome(Node<T> head) {
        if (head == null) return false;
        Node<T> slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        Node<T> right, left = head, temp;
        if (fast != null) {
            prev.next = null;
        }
        right = reverse(slow);
        temp = right;
        while (left != null && right != null) {
            if (left.data != right.data) {
                prev.next = reverse(temp);//To recover original state
                return false;
            }
            left = left.next;
            right = right.next;
        }
        prev.next = reverse(temp);//To recover original state
        return true;
    }


    public Node<T> getMidNode(Node<T> head) {
        if (head == null) return null;
        Node<T> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //WRONG
    public void detectRemoveLoop(Node<T> head) {
        if (head == null || head.next == null) return;
        Node<T> slow = head, fast = head.next.next, meetingPoint = null;
        while (fast != null && fast.next != null) {
            if (slow == fast) break;
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }
}
