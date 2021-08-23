package com.vikydroid.mylib.oldIntel.practice.practice7.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> {
    Node<T> root;

    int height(Node<T> root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    Node<T> invert(Node<T> root) {
        if (root == null) return null;
        Node<T> tempL = root.left;
        root.left = root.right;
        root.right = tempL;
        invert(root.left);
        invert(root.right);
        return root;
    }

    boolean isIdentical(Node<T> root1, Node<T> root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.data == root2.data
                && isIdentical(root1.left, root2.left)
                && isIdentical(root1.right, root2.right);
    }

    void levelOrder(Node<T> root) {
        if (root == null) return;
        Queue<Node<T>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node<T> temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
    }

    void levelOrderR(Node<T> root) {
        if (root == null) return;
        int h = height(root);
        for (int i = 0; i < h; i++) {
            helperLO(root, i);
            System.out.println();
        }
    }

    private void helperLO(Node<T> root, int i) {
        if (root == null) return;
        if (i == 0) {
            System.out.print(root.data + " ");
        }
        if (i > 0) {
            helperLO(root.left, i - 1);
            helperLO(root.right, i - 1);
        }
    }

    void zigZag(Node<T> root) {
        if (root == null) return;
        Stack<Node<T>> stack1 = new Stack<>(), stack2 = new Stack<>();
        stack1.add(root);
        boolean isLTR = true;
        while (!stack1.isEmpty()) {
            Node<T> temp = stack1.pop();
            System.out.print(temp.data + " ");
            if (isLTR) {
                if (temp.left != null) stack2.add(temp.left);
                if (temp.right != null) stack2.add(temp.right);
            } else {
                if (temp.right != null) stack2.add(temp.right);
                if (temp.left != null) stack2.add(temp.left);
            }
            if (stack1.isEmpty()) {
                isLTR = !isLTR;
                stack1 = stack2;
                stack2 = new Stack<>();
            }
        }
    }

    void verticalOder(Node<T> root) {
        if (root == null) return;
        int leftMax = getLeft(root, 0);
        int rightMax = getLRight(root, 0);
        for (int i = leftMax; i <= rightMax; i++) {
            helperVO(root, 0, i);
            System.out.println();
        }
    }

    private void helperVO(Node<T> root, int start, int target) {
        if (root == null) return;
        if (start == target) {
            System.out.print(root.data + " ");
        }
        helperVO(root.left, start - 1, target);
        helperVO(root.right, start + 1, target);
    }

    private int getLeft(Node<T> root, int level) {
        if (root.left != null)
            return Math.min(level, getLeft(root.left, level - 1));
        if (root.right != null)
            return Math.min(level, getLeft(root.right, level + 1));
        return level;
    }

    private int getLRight(Node<T> root, int level) {
        if (root.right != null)
            return Math.max(level, getLRight(root.right, level + 1));
        if (root.left != null)
            return Math.max(level, getLRight(root.left, level - 1));
        return level;
    }

    boolean hasPathSum(Node<Integer> root, int k) {
        if (root == null && k == 0) return true;
        if (root == null) return false;
        return hasPathSum(root.left, k - root.data)
                || hasPathSum(root.right, k - root.data);

    }

    void printLeftView(Node<T> root) {
        if (root == null) return;
        helperPLV(root, 1);
    }

    int maxLevel = 0;

    private void helperPLV(Node<T> root, int i) {
        if (root == null) return;
        if (maxLevel < i) {
            System.out.print(root.data + " ");
            maxLevel = i;
        }
        helperPLV(root.left, i + 1);
        helperPLV(root.right, i + 1);
    }

    void printBoundary(Node<T> root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }

    private void printLeftBoundary(Node<T> root) {
        if (root == null) return;
        if (root.left != null) {
            System.out.print(root.data + " ");
            printLeftBoundary(root.left);
        } else if (root.right != null) {
            System.out.print(root.data + " ");
            printLeftBoundary(root.right);
        }
    }

    private void printLeaves(Node<T> root) {
        if (root == null) return;
        printLeaves(root.left);
        if (root.left == null && root.right != null) {
            System.out.print(root.data + " ");
        }
        printLeaves(root.right);
    }

    private void printRightBoundary(Node<T> root) {
        if (root == null) return;

        if (root.right != null) {
            printRightBoundary(root.right);
            System.out.print(root.data + " ");
        } else if (root.left != null) {
            printRightBoundary(root.left);
            System.out.print(root.data + " ");
        }
    }

}
