package com.vikydroid.mylib.oldIntel.practice.practice2.tree;

public class BST<T> extends Tree<Integer> {

    public Node<Integer> add(Node<Integer> root, Integer data) {
        Node<Integer> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
            return root;
        }
        if (data < root.data) {
            root.left = add(root.left, data);
        }
        if (data > root.data) {
            root.right = add(root.right, data);
        }
        return root;
    }

    public Node<Integer> search(Node<Integer> root, int data) {
        if (root == null || root.data == data)
            return root;
        if (root.data > data)
            return search(root.left, data);
        return search(root.right, data);
    }

    public Node<Integer> delete(Node<Integer> root, int data) {
        if (root == null) return null;
        if (data < root.data)
            root.left = delete(root.left, data);
        else if (data > root.data)
            root.right = delete(root.right, data);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = getMin(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }


    //WRONG
    public boolean isBST(Node<Integer> root) {
        if (root == null) return true;
        if (root.left != null) {
            if (root.left.data < root.data) {
                return isBST(root.left);
            } else return false;
        }
        if (root.right != null) {
            if (root.right.data > root.data) {
                return isBST(root.right);
            } else return false;
        }
        return true;
    }
    //WRONG
    public boolean isBST2(Node<Integer> root) {
        if (root == null) return true;
        if (root.left != null && root.left.data > root.data)
            return false;
        if (root.right != null && root.right.data < root.data)
            return false;
        return isBST(root.left) && isBST(root.right);
    }


    public boolean isBST3(Node<Integer> root) {
        if (root == null) return true;
        if (root.left != null && root.data < getMax(root.left))//max in left subtree
            return false;
        if (root.right != null && root.data > getMin(root.right))//min in right subtree
            return false;
        return isBST3(root.left) && isBST3(root.right);
    }

    /**
     * Correct ONE
     *
     * @param root
     * @return
     */
    public boolean isBST4(Node<Integer> root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(Node<Integer> root, int min, int max) {
        if (root == null) return true;
        if (root.data < min || root.data > max) {
            return false;
        }
        return isBSTUtil(root.left, min, root.data - 1)
                && isBSTUtil(root.right, root.data - 1, max);

    }

    /**
     * Most Efficient and easy same as isBST4()
     *
     * @param root
     * @return
     */
    public boolean isBST5(Node<Integer> root) {
        return isBSTUtil(root, null, null);
    }

    private boolean isBSTUtil(Node<Integer> root, Node<Integer> left, Node<Integer> right) {
        if (root == null) return true;
        if (left != null && root.data <= left.data)
            return false;
        if (right != null && root.data >= right.data)
            return false;
        return isBSTUtil(root.left, left, root)
                && isBSTUtil(root.right, root, right);
    }

    //WRONG
    private int getMax(Node<Integer> root) {
        int max = root.data;
        while (root.right != null) {
            max = root.right.data;
            root = root.right;
        }
        return max;
    }

    //WRONG
    private int getMin(Node<Integer> root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }


    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        /*tree.root = new Node<>(10);
        for (int i = 0; i < 5; i++) {
            tree.add(tree.root, i);
        }*/
//        tree.add(2, tree.root);
//        tree.add(6, tree.root);
//        tree.add(5, tree.root);
//        tree.add(1, tree.root);
//        tree.add(3, tree.root);
        tree.inOrder();
        System.out.println();
        tree.postOrder();
        System.out.println();
        System.out.println(tree.isBST(tree.root));
        System.out.println(tree.isBST2(tree.root));
        System.out.println(tree.isBST3(tree.root));
        System.out.println(tree.isBST4(tree.root));
        System.out.println(tree.isBST5(tree.root));

        tree.root = tree.delete(tree.root, 1);
        tree.inOrder();
        System.out.println();
        tree.root = tree.delete(tree.root, 2);
        tree.inOrder();

    }
}



