package com.vikydroid.mylib.oldIntel.practice.practice2.tree;

public class ConstructTree {
    Tree<Character> tree = new Tree<>();
    Tree<Character> tree2 = new Tree<>();
    char[] inOrder = {'D', 'B', 'E', 'A', 'F', 'C'};
    char[] preOrder = {'A', 'B', 'D', 'E', 'C', 'F'};
    char[] postOrder = {'D', 'E', 'B', 'F', 'C', 'A'};
    int preIndex, postIndex = postOrder.length - 1;

    public static void main(String[] args) {
        ConstructTree constructTree = new ConstructTree();
        int n = constructTree.inOrder.length;
        constructTree.tree = new Tree<>();
        constructTree.tree.root = constructTree
                .constructFromPost(constructTree.inOrder, constructTree.postOrder, 0, n - 1);
        constructTree.tree2.root = constructTree
                .constructFromPre(constructTree.inOrder, constructTree.preOrder, 0, n - 1);
        constructTree.tree.inOrder();
        System.out.println();
        constructTree.tree.preOrder();
        System.out.println();
        constructTree.tree.postOrder();

    }

    public Node<Character> constructFromPre(char[] inOrder, char[] preOrder, int start, int end) {
        if (start > end)
            return null;
        Node<Character> node = new Node<>(preOrder[preIndex++]);
        if (start == end)
            return node;
        int inIndex = search(inOrder, start, end, node.data);
        node.left = constructFromPre(inOrder, preOrder, start, inIndex - 1);
        node.right = constructFromPre(inOrder, preOrder, inIndex + 1, end);
        return node;
    }

    private int search(char[] in, int start, int end, char val) {
        int i;
        for (i = start; i <= end; i++) {
            if (in[i] == val) {
                return i;
            }
        }
        return i;
    }


    public Node<Character> constructFromPost(char[] inOrder, char[] postOrder, int start, int end) {
        if (start > end)
            return null;
        Node<Character> node = new Node<>(postOrder[postIndex--]);
        if (start == end)
            return node;
        int outIndex = search(inOrder, start, end, node.data);
        node.right = constructFromPost(inOrder, postOrder, outIndex + 1, end);
        node.left = constructFromPost(inOrder, postOrder, start, outIndex - 1);
        return node;
    }

}
