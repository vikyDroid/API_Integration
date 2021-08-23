package com.vikydroid.mylib.oldIntel.interviews;

import com.practice.practice.practice2.tree.Node;
import com.practice.practice.practice2.tree.Tree;

public class TripletSumInTree {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.root = new Node<>(2);
        int x = 100;
        System.out.println(numOfPairs(tree.root, 100));
    }

    private static int numOfPairs(Node<Integer> root, int x) {
        int num = 0;
        if (isTriplet(root, x)) {
            num++;
        }

        return 0;
    }

    private static boolean isTriplet(Node<Integer> root, int x) {
        if (root == null && x == 0) return true;
        if (root == null) return false;
        return isTriplet(root.left, x - root.data)
                || isTriplet(root.right, x - root.data);

//        return false;
    }
}
