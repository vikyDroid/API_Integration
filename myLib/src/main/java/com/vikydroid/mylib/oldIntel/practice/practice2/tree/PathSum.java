package com.vikydroid.mylib.oldIntel.practice.practice2.tree;

public class PathSum {
    static int max = Integer.MIN_VALUE;
    static int max2 = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.root = new Node<>(-10);
        tree.root.left = new Node<>(-9);
//        tree.root.left.left = new Node<>(3);
//        tree.root.left.right = new Node<>(5);
        tree.root.right = new Node<>(-20);
        tree.root.right.left = new Node<>(-15);
        tree.root.right.right = new Node<>(7);
        int sum = 14;
        System.out.println(new PathSum().hasPathSum(tree.root, sum));
        int x1 = new PathSum().maxPathSum(tree.root);
        System.out.println(max);
        int x = new PathSum().maxPathSum2(tree.root);
        System.out.println(max2);
    }

    public boolean hasPathSum(Node<Integer> root, int sum) {
        if (root == null)
            return sum == 0;
        return hasPathSum(root.left, sum - root.data)
                || hasPathSum(root.right, sum - root.data);

    }

    //From Leetcode
    private int maxPathSum(Node<Integer> root) {
        if (root == null)  return 0;
        int left = Math.max(maxPathSum(root.left), 0);
        int right = Math.max(maxPathSum(root.right), 0);
        max = Math.max(max, root.data + left + right);
        return root.data + Math.max(left, right);
    }

    //self but ALMOST same as above
    int maxPathSum2(Node<Integer> root) {
        if (root == null) return 0;
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        max2 = Math.max(max2, root.data + left + right);
        return root.data + Math.max(left, right);
    }

}
