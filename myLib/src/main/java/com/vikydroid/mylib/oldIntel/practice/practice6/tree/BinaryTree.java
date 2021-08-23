package com.vikydroid.mylib.oldIntel.practice.practice6.tree;

import java.util.*;

public class BinaryTree<T> {
    public Node<T> root;

    int height(Node<T> root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    void levelOrder(Node<T> root) {
        for (int i = 1; i <= height(root); i++) {
            helper(root, i);
            System.out.println();
        }
    }

    private void helper(Node<T> root, int level) {
        if (root == null) return;
        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            helper(root.left, level - 1);
            helper(root.right, level - 1);
        }
    }

    void levelOrderNR(Node<T> root) {
        for (int i = 1; i <= height(root); i++) {
            helperNR(root, i);
            System.out.println();
        }
    }

    private void helperNR(Node<T> root, int level) {
        if (root == null) return;
        if (level == 1) {
            System.out.print(root.nextRight + " --> ");
        } else if (level > 1) {
            helperNR(root.left, level - 1);
            helperNR(root.right, level - 1);
        }
    }

    //O(n^2)
    void verticalTraversal(Node<T> root) {
        HashMap<Integer, Node<T>> map = new HashMap<>();
        setMin(root, 0, map);
        setMax(root, 0, map);
        for (int i = min; i <= max; i++) {
            level = i;
            helperVertical(root, 0);
            System.out.println();
        }
    }

    //O(n)
    void verticalTraversal2(Node<T> root) {
        TreeMap<Integer, ArrayList<Node<T>>> map = new TreeMap<>();
        preOder(root, map, 0);
        System.out.println();
    }

    void preOder(Node<T> root, TreeMap<Integer, ArrayList<Node<T>>> map, int level) {
        if (root == null) return;
        preOder(root.left, map, level - 1);
        ArrayList<Node<T>> list = map.getOrDefault(level, new ArrayList<>());
        list.add(root);
        map.put(level, list);
        preOder(root.right, map, level + 1);
    }

    void helperVertical(Node<T> root, int i) {
        if (root == null) return;
        if (i == level) System.out.print(root.data + " ");
        helperVertical(root.left, i - 1);
        helperVertical(root.right, i + 1);
    }

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int level;

    void setMin(Node<T> root, int i, HashMap<Integer, Node<T>> map) {
        if (root == null) return;
        int temp = min;
        min = Math.min(min, i);
        if (temp != min) {
            map.put(min, root);
        }
        if (root.left != null)
            setMin(root.left, i - 1, map);
        else
            setMin(root.right, i + 1, map);
    }

    void setMax(Node<T> root, int i, HashMap<Integer, Node<T>> map) {
        if (root == null) return;
        int temp = max;
        max = Math.max(max, i);
        if (temp != max) {
            map.put(max, root);
        }
        if (root.right != null)
            setMax(root.right, i + 1, map);
        else
            setMax(root.left, i - 1, map);
    }

    public void preOder(Node<T> root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOder(root.left);
        preOder(root.right);
    }

    public void postOder(Node<T> root) {
        if (root == null) return;
        postOder(root.left);
        postOder(root.right);
        System.out.print(root.data + " ");
    }

    void leftView(Node<T> root) {
        min = Integer.MAX_VALUE;
        helperLeftView(root, 0);
    }

    private void helperLeftView(Node<T> root, int i) {
        if (root == null) return;
        if (i < min) {
            min = i;
            System.out.print(root.data + " ");
        }
        helperLeftView(root.left, i - 1);
        helperLeftView(root.right, i - 1);
    }

    void leftView2(Node<T> root) {
        min = Integer.MIN_VALUE;
        helperLeftView2(root, 1);
    }

    private void helperLeftView2(Node<T> root, int i) {
        if (root == null) return;
        if (i > min) {
            min = i;
            System.out.print(root.data + " ");
        }
        helperLeftView2(root.left, i + 1);
        helperLeftView2(root.right, i + 1);
    }

    void flatten(Node<T> root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        if (root.left != null) {
            flatten(root.left);
            Node<T> temp = root.right;
            root.right = root.left;
            root.left = null;

            Node<T> curr = root;
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = temp;
        }
        flatten(root.right);
    }

    void connect(Node root) {
        if (root != null) {
            Queue<Node> q1 = new LinkedList<Node>();
            Queue<Node> q2 = new LinkedList<Node>();
            q1.add(root);
            while (!q1.isEmpty()) {
                Node temp = q1.poll();
                if (q1.isEmpty()) {
                    temp.nextRight = null;
                } else {
                    temp.nextRight = q1.peek();
                }
                if (temp.left != null) q2.add(temp.left);
                if (temp.right != null) q2.add(temp.right);
                if (q1.isEmpty()) {
                    q1 = q2;
                    q2 = new LinkedList<Node>();
                }
            }
        }
    }

    //O(1) sapce
    void connect2(Node<T> root) {
        if (root == null) return;
        if (root.nextRight != null)
            connect2(root.nextRight);
        if (root.left != null) {
            if (root.right != null) {
                root.left.nextRight = root.right;
                root.right.nextRight = getNR(root);
            } else {
                root.left.nextRight = getNR(root);
            }
            connect2(root.left);
        } else if (root.right != null) {
            root.right.nextRight = getNR(root);
            connect2(root.right);
        } else
            connect2(getNR(root));

    }

    private Node<T> getNR(Node<T> root) {
        Node<T> curr = root.nextRight;
        while (curr != null) {
            if (curr.left != null) return curr.left;
            if (curr.right != null) return curr.right;
            curr = curr.nextRight;
        }
        return null;
    }

    void printLeaves(Node<T> root) {
        if (root==null)return;
        printLeaves(root.left);
        if (root.left==null && root.right==null)
            System.out.print(root.data+" ");
        printLeaves(root.right);
    }
}
