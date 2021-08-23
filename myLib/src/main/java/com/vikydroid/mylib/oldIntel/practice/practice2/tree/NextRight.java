package com.vikydroid.mylib.oldIntel.practice.practice2.tree;

import com.practice.practice.practice2.templateT.Queue;

public class NextRight {
    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.left.left = new Node(4);
        tree.left.left.left = new Node(8);
        tree.left.left.right = new Node(9);
        tree.left.right = new Node(5);
        tree.right = new Node(3);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        tree.right.right.left = new Node(10);
        tree.right.right.right = new Node(11);

//        tree.levelOrder();

//        System.out.println();
//        tree.preOrder();
        new NextRight().connect5(tree);
        new NextRight().printConnected(tree);
    }

    public void connect(Node root) {
        Queue<Node> queue = new Queue<>();
        queue.add(root);
        Node temp = null;
        while (!queue.isEmpty()) {
            int n = queue.length();
            for (int i = 0; i < n; i++) {
                Node prev = temp;
                temp = queue.poll();
                if (i > 0) {
                    prev.nextRight = temp;
                }
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            temp.nextRight = null;
        }
    }

    //won't work for non-complete tree
    public void connect2(Node root) {
        if (root == null) return;
        if (root.left != null)
            root.left.nextRight = root.right;
        if (root.right != null)
            root.right.nextRight = root.nextRight == null ? null : root.nextRight.left;
        connect2(root.left);
        connect2(root.right);
    }

    //will work for non-complete tree
    public void connect3(Node root) {
        if (root == null) return;

        if (root.nextRight != null)
            connect3(root.nextRight);

        if (root.left != null) {
            if (root.right != null) {
                root.left.nextRight = root.right;
                root.right.nextRight = getNextRight(root);
            } else {
                root.left.nextRight = getNextRight(root);
            }
            connect3(root.left);
        } else if (root.right != null) {
            root.right.nextRight = getNextRight(root);
            connect3(root.right);
        } else
            connect3(getNextRight(root));
    }

    /**
     * Most efficient and with least space required
     *
     * @param root
     */
    public void connect4(Node root) {
        if (root == null) return;
        while (root != null) {
            Node temp = root;
            while (temp != null) {
                if (temp.left != null) {
                    if (temp.right != null) {
                        temp.left.nextRight = temp.right;
                    } else {
                        temp.left.nextRight = getNextRight(temp);
                    }
                }
                if (temp.right != null) {
                    temp.right.nextRight = getNextRight(temp);
                }
                temp = temp.nextRight;
            }
            if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else
                root = getNextRight(root);
        }
    }

    //O(n) but space required
    public void connect5(Node root) {
        if (root == null) return;
        Queue<Node> q = new Queue<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp != null) {
                temp.nextRight = q.top();

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            } else if (!q.isEmpty()) {
                q.add(null);
            }
        }
    }

    private Node getNextRight(Node root) {
        Node temp = root.nextRight;
        while (temp != null) {
            if (temp.left != null) return temp.left;
            if (temp.right != null) return temp.right;
            temp = temp.nextRight;
        }
        return null;
    }

    public void printConnected(Node root) {
        System.out.println();
        if (root == null) return;
        Node temp = root;
        while (temp != null) {
            Node temp2 = temp;
            while (temp2 != null) {
                System.out.print(temp2.data + "->");
                temp2 = temp2.nextRight;
            }
            System.out.println();
            if (temp.left != null)
                temp = temp.left;
            else temp = temp.right;

        }
    }


    static class Node {
        int data;
        Node left, right, nextRight;

        Node(int data) {
            this.data = data;
        }
    }
}

