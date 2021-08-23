package com.vikydroid.mylib.oldIntel.practice.practice2.tree;

public class LeftRightView {
    static int level_left = 0;
    static int level_right = 0;

    public static void main(String[] args) {
       /* Tree<Integer> tree = new Tree<>();
        tree.root = new Node<>(4);
        tree.root.left = new Node<>(5);
        tree.root.right = new Node<>(2);
        tree.root.right.left = new Node<>(3);
        tree.root.right.right = new Node<>(1);
        tree.root.right.left.left = new Node<>(6);
        tree.root.right.left.right = new Node<>(7);
        new LeftRightView().printLeftView(tree.root, 1);
        System.out.println();
        new LeftRightView().printRightView(tree.root, 1);
        System.out.println("==))))))))))))))))))))))))))))))))))))))");
        tree.levelOrder();
        System.out.println();
        tree.levelOrder2(tree.root);*/


        Tree<Integer> tree = new Tree<>();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        printBoundaryAndLeaves(tree.root);


    }

    private static void printBoundaryAndLeaves(Node<Integer> root) {
        printLeftView(root, 0);
        printRightView(root, 1);
    }

    public static void printLeftView(Node<Integer> root, int level) {
        if (root == null) return;
        if (level_left < level) {
            System.out.print(root.data + " ");
            level_left++;
        }
        printLeftView(root.left, level + 1);
        printLeftView(root.right, level + 1);
    }

    public static void printRightView(Node<Integer> root, int level) {
        if (root == null) return;
        if (level_right < level) {
            System.out.print(root.data + " ");
            level_right++;
        }
        printRightView(root.right, level + 1);
        printRightView(root.left, level + 1);
    }


}
