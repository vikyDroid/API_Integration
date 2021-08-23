package com.vikydroid.mylib.oldIntel.practice.practice6.tree;

import java.util.TreeMap;
import java.util.Vector;

public class TestTreeFunctions {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
    /*    1
        /   \
       2     5
      / \     \
     3   4     6 */

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.right = new Node(6);

//        tree.printLeaves(tree.root.left);
        tree.printLeaves(tree.root.right);
    }

    static void verticalTraversal2(Node<Integer> root) {
        TreeMap<Integer, Vector<Node<Integer>>> map = new TreeMap<>();
        preOder(root, map, 0);
        for (int key : map.keySet()) {
            for (int i = 0; i < map.get(key).size(); i++) {
                System.out.print(map.get(key).get(i).data + " ");
            }
            System.out.println();
        }
    }

    static void preOder(Node<Integer> root, TreeMap<Integer, Vector<Node<Integer>>> map, int level) {
        if (root == null) return;
        Vector<Node<Integer>> list = map.getOrDefault(level, new Vector<>());
        list.add(root);
        map.put(level, list);
        preOder(root.left, map, level - 1);
        preOder(root.right, map, level + 1);
    }


}
