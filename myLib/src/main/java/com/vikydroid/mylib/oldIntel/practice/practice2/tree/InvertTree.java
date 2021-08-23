package com.vikydroid.mylib.oldIntel.practice.practice2.tree;

import com.practice.practice.practice2.templateT.Queue;

public class InvertTree<T> {

    public static void main(String[] args) {
    }

    public void invertTreeR(Node<T> root) {
        if (root == null || (root.left == null && root.right == null)) return;
        Node<T> temp;
        if (root.left != null) {
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        } else {
            temp = root.right;
            root.right = null;
            root.left = temp;
        }
        invertTreeR(root.left);
        invertTreeR(root.right);
    }

    public void invertTree(Node<T> root) {
        if (root == null) return;
        Queue<Node<T>> queue = new Queue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> curr = queue.dequeue(), temp;
            temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (curr.left != null)
                queue.add(curr.left);

            if (curr.right != null)
                queue.add(curr.right);
        }
    }
}
