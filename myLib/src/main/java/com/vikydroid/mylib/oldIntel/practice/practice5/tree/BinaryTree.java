package com.vikydroid.mylib.oldIntel.practice.practice5.tree;

import com.practice.practice.practice2.templateT.Queue;
import com.practice.practice.practice2.templateT.Stack;

public class BinaryTree<T> {
    Node<T> root;
    static int preIndex = 0;

    int height(Node<T> root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    void invertTree(Node<T> root) {
        if (root == null) return;
        Node<T> left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
    }

    boolean isIdentical(Node<T> root1, Node<T> root2) {
        if (root1 == root2) return true;
        if (root1 != null && root2 != null
                && root1.data == root2.data) {
            return isIdentical(root1.left, root2.left)
                    && isIdentical(root1.right, root2.right);
        } else return false;
    }

    void levelOrder(Node<T> root) {
        Queue<Node<T>> queue = new Queue<>();
        if (root != null) {
            queue.enqueue(root);
        }
        while (!queue.isEmpty()) {
            Node<T> top = queue.poll();
            System.out.print(top.data + " ");
            if (top.left != null) {
                queue.enqueue(top.left);
            }
            if (top.right != null) {
                queue.enqueue(top.right);
            }
        }
    }

    void zigZag(Node<T> root) {
        Stack<Node<T>> s1 = new Stack<>(), s2 = new Stack<>();
        if (root != null) s1.add(root);
        boolean isRTL = false;
        while (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node<T> top = s1.pop();
                if (isRTL) {
                    if (top.right != null) s2.add(top.right);
                    if (top.left != null) s2.add(top.left);
                } else {
                    if (top.left != null) s2.add(top.left);
                    if (top.right != null) s2.add(top.right);
                }
                System.out.print(top.data + " ");
            }
            isRTL = !isRTL;
            s1 = s2;
            s2 = new Stack<>();
        }
    }

    void preOrder(Node<T> root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void preOrder2(Node<T> root) {
        Stack<Node<T>> stack = new Stack<>();
        if (root != null) stack.add(root);
        while (!stack.isEmpty()) {
            Node<T> top = stack.pop();
            System.out.print(top.data + " ");
            if (top.right != null) stack.add(top.right);
            if (top.left != null) stack.add(top.left);
        }
    }

    void inOrder(Node<T> root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    void inOrder2(Node<T> root) {
        if (root == null) return;
        if (root.left != null) {
            root = root.left;
        }
        System.out.println(root.data);
    }

    void postOrder(Node<T> root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    Node<Character> createTree(String in, String pre, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;
        char c = pre.charAt(preIndex++);
        Node<Character> root = new Node<>(c);
        if (inStart == inEnd)
            return root;
        int inIndex = getInIndex(in, pre, c);
        root.left = createTree(in, pre, inStart, inIndex - 1);
        root.right = createTree(in, pre, inIndex + 1, inEnd);
        return root;
    }

    private int getInIndex(String in, String pre, char c) {
        int inIndex = -1;
        for (int i = 0; i < pre.length(); i++) {
            if (c == in.charAt(i)) {
                inIndex = i;
                break;
            }
        }
        return inIndex;
    }


    //wrong
    public boolean isPathSum(Node<Integer> root, int x) {
        if (root == null) return x == 0;
        return isPathSum(root.left, x - root.data)
                || isPathSum(root.right, x - root.data);
    }

    static public int maxPathSum(Node<Integer> root) {
        int max = Integer.MIN_VALUE;
        int left = Math.max(root.data, root.data + root.left.data);
        int right = Math.max(root.data, root.data + root.right.data);

        max = Math.max(max, root.data + root.left.data + root.right.data);
        return max;
    }

    void leftView(Node<T> root) {

    }

    void flattenTree(Node<T> root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        if (root.left != null) {
            flattenTree(root.left);
            Node<T> temp = root.right;
            root.right = root.left;
            root.left = null;

            Node<T> curr = root.right;
            while (curr.right != null)
                curr = curr.right;
            curr.right = temp;
        }
        flattenTree(root.right);
    }


    //wrong
    boolean isBST(Node<Integer> root) {
        if (root == null) return true;
        if (root.left.data < root.data && root.right.data > root.data) {
            return isBST(root.right) && isBST(root.left);
        } else return false;
    }

    void nextRight(Node<T> root){

    }
}
