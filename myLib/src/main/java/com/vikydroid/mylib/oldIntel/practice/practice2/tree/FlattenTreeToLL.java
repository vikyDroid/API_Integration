package com.vikydroid.mylib.oldIntel.practice.practice2.tree;

import com.vikydroid.mylib.oldIntel.practice.practice2.templateT.Stack;

public class FlattenTreeToLL {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.root = new Node<>(1);
        tree.root.left = new Node<>(2);
        tree.root.left.left = new Node<>(3);
        tree.root.left.right = new Node<>(4);
        tree.root.right = new Node<>(5);
        tree.root.right.right = new Node<>(6);
        tree.preOrder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.levelOrder();
        System.out.println("\nAfter");
        new FlattenTreeToLL().flatten4(tree.root);
        tree.levelOrder();
    }

    //Efficient no extra space via recursion
    public void flatten(Node<Integer> root) {
        if (root == null || (root.left == null && root.right == null)) return;
        if (root.left != null) {
            flatten(root.left);
            Node<Integer> right = root.right;
            root.right = root.left;
            root.left = null;

            Node<Integer> temp = root.right;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = right;
        }
        flatten(root.right);
    }

    //Using Stack
    public void flatten4(Node<Integer> root) {
        if (root == null) return;
        Stack<Node<Integer>> stack = new Stack<>();
        Node<Integer> curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr.right != null) {
                stack.add(curr.right);
            }
            curr.right = curr.left;
            curr.left = null;

            if (curr.right == null && !stack.isEmpty()) {
                curr.right = stack.pop();
            }
            curr = curr.right;
        }
    }

    //In-complete using queue
    /*public Node<Integer> flatten2(Node<Integer> root) {
        if (root == null) return null;
        Node<Integer> prev = root;
        Queue<Node<Integer>> queue = new Queue<>();
        while (prev != null || !queue.isEmpty()) {
            Node<Integer> temp = queue.poll();
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
//            root = temp;
//            root = root.right;
            prev.right = temp;
            prev.left = null;
            prev = prev.right;
        }
        return prev;
    }*/
}
