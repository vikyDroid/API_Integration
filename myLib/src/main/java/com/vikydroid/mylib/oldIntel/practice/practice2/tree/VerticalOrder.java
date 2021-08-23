package com.vikydroid.mylib.oldIntel.practice.practice2.tree;

import java.util.*;

public class VerticalOrder<T> {
    Tree<T> tree;
    int min, max;
    TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<>();

    public static void main(String[] args) {
        VerticalOrder<Integer> obj = new VerticalOrder<>();
        obj.tree = new Tree<>();
        obj.tree.root = new Node(1);
        obj.tree.root.left = new Node(2);
        obj.tree.root.right = new Node(3);
        obj.tree.root.left.left = new Node(4);
        obj.tree.root.left.right = new Node(5);
        obj.tree.root.right.left = new Node(6);
        obj.tree.root.right.right = new Node(7);
        obj.tree.root.right.left.right = new Node(8);
        obj.tree.root.right.right.right = new Node(9);

        obj.verticalOrder(obj.tree.root);
        System.out.println();
        obj.verticalOrder2(obj.tree.root, 0);
        for (Map.Entry entry : obj.map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    //Efficient
    public void verticalOrder2(Node<T> root, int currLine) {
        if (root == null) return;
        LinkedList<Integer> list = map.get(currLine);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add((Integer) root.data);
        map.put(currLine, list);

        verticalOrder2(root.left, currLine - 1);
        verticalOrder2(root.right, currLine + 1);
    }

    public void verticalOrder(Node<T> root) {
        getMinMax(root, 0);
        if (root == null) return;
        for (int i = min; i <= max; i++) {
            printVerticalLevel(root, i, 0);
            System.out.println();
        }
    }

    private void printVerticalLevel(Node<T> root, int lineNo, int cureLine) {
        if (root == null) return;
        if (lineNo == cureLine)
            System.out.print(root.data + " ");
        printVerticalLevel(root.left, lineNo, cureLine - 1);
        printVerticalLevel(root.right, lineNo, cureLine + 1);
    }

    private void getMinMax(Node<T> root, int curr) {
        if (root == null) return;
        if (curr < min) min = curr;
        if (curr > max) max = curr;
        getMinMax(root.left, curr - 1);
        getMinMax(root.right, curr + 1);
    }
}
