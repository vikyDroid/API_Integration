package com.vikydroid.mylib.oldIntel.practice.practice5.ll;

class LinkedList<T> {
    Node<T> head;

    @Override
    public String toString() {
        return head.toString();
    }

    Node<T> reverseLL(Node<T> head) {
        Node<T> curr = head, prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    Node<T> reverseInGroup2(Node<T> curr, int k, LinkedList<T> list) {
        Node<T> prev = null, next = null;
        int i = 0;
        while (curr != null && i < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        Node<T> lastNode = null;
        if (curr != null) {
            lastNode = reverseInGroup2(curr, k, list);
        }
        Node<T> temp = prev;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = lastNode;
        return prev;
    }

    boolean isPalindrome(LinkedList<T> list) {
        Node<T> slow = list.head, fast = list.head, prev = null, mid = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        Node<T> left = list.head, right, temp;
        if (fast == null) {
            right = reverseLL(slow);
        } else {
            mid = slow;
            right = reverseLL(slow.next);
        }
        temp = right;
        while (left != null && right != null) {
            if (left.data != right.data) {
                revertChanges(prev, mid, temp);
                return false;
            }
            left = left.next;
            right = right.next;
        }
        revertChanges(prev, mid, temp);
        return true;
    }

    private void revertChanges(Node<T> prev, Node<T> mid, Node<T> temp) {
        if (mid == null) {
            prev.next = reverseLL(temp);
        } else {
            mid.next = reverseLL(temp);
            prev.next = mid;
        }
    }

    void add(Node<T> node) {
        if (this.head == null) {
            this.head = node;
        } else {
            Node<T> curr = this.head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
    }

    void add2(Node<T> node) {
        node.next = this.head;
        this.head = node;
    }

    /**
     * Incomplete
     */
    void detectAndRemoveLoop(LinkedList<T> list) {
        Node<T> slow = list.head, fast = list.head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Yes, there is a loop");
                return;
            }
        }
        System.out.println("Yes, there is NO loop");
    }

    LinkedList<T> rearrange(LinkedList<T> list) {
        Node<T> slow = list.head, fast = list.head, prev = null, mid = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        Node<T> left = list.head, right;
        if (fast == null) {
            right = reverseLL(slow);
        } else {
            mid = slow;
            right = reverseLL(slow.next);
        }

        LinkedList<T> ans = new LinkedList<>();
        while (left != null && right != null) {
            ans.add(new Node<>(left.data));
            ans.add(new Node<>(right.data));
            left = left.next;
            right = right.next;
        }
        if (mid != null) {
            mid.next = null;
        }
        ans.add(mid);
        return ans;
    }

}
