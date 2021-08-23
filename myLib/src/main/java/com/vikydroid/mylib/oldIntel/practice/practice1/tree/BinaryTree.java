package com.vikydroid.mylib.oldIntel.practice.practice1.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    Node root;

    public void insert(Node temp, int key) {
        Queue<Node> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty()) {
            temp = q.poll();
            Node newNode = new Node(key);
            if (temp == null) {
                temp = newNode;
            }
            if (temp.left == null) {
                temp.left = newNode;
                break;
            } else {
                q.add(temp.left);
            }
            if (temp.right == null) {
                temp.right = newNode;
                break;
            } else {
                q.add(temp.right);
            }
        }
    }

    /*//wrong
    public void insert2(Node root, int key) {
        Node newNode = new Node(key);
        if (root == null) {
            this.root = newNode;
            return;
        }
        if (root.left == null) {
            root.left = newNode;
            return;
        }
        if (root.right == null) {
            root.right = newNode;
            return;
        }
        insert2(root.left, key);
        insert2(root.right, key);
    }
*/
    public Node delete(Node root, int key) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null) {
            if (root.data == key) {
                return null;
            } else {
                return root;
            }
        }
        //Level order traversal
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node item = null;
        Node last = null;
        while (!q.isEmpty()) {
            last = q.poll();
            if (last.data == key) {
                item = last;
            }
            if (last.left != null) {
                q.add(last.left);
            }
            if (last.right != null) {
                q.add(last.right);
            }
        }

        if (item != null) {
            int x = last.data;
            getDeepestRightNode(root, item);
            item.data = x;
        }


        return root;
    }

    private Node getDeepestRightNode(Node root, Node item) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp == item) {
                return null;
            }
            if (temp.right != null) {
                if (temp.right == item) {
                    temp.right = null;
                    return root;
                } else
                    q.add(temp.right);
            }
            if (temp.left != null) {
                if (temp.left == item) {
                    temp.left = null;
                    return root;
                } else
                    q.add(temp.left);
            }

        }
        return root;
    }

    public void printInOrder(Node root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(" " + root.data);
        printInOrder(root.right);
    }

    public void preOrder(Node root) {
        if (root == null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public void inOrderStack(Node root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Stack<Node> s = new Stack<>();
        Node curr = root;
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.add(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.println(curr.data);
            curr = curr.right;
        }

    }

    //MorrisTraversal
    public void inOrderNonStack(Node root) {
        Node curr = root;
        while (curr != null) {
            if (curr.left == null) {
                System.out.println(curr.data);
                curr = curr.right;
            } else {

            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(10);
        tree.insert(tree.root, 10);
        tree.insert(tree.root, 100);
        tree.insert(tree.root, 200);
        tree.insert(tree.root, 300);
        tree.insert(tree.root, 400);
        tree.insert(tree.root, 500);
        tree.printInOrder(tree.root);
    }
}
