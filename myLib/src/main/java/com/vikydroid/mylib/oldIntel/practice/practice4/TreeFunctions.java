package com.vikydroid.mylib.oldIntel.practice.practice4;

import com.practice.practice.practice2.templateT.Queue;
import com.practice.practice.practice2.templateT.Stack;
import com.practice.practice.practice2.tree.Node;
import com.practice.practice.practice2.tree.Tree;

public class TreeFunctions {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.root = new Node<>(-10);
        tree.root.left = new Node<>(9);
        tree.root.right = new Node<>(20);
        tree.root.right.left = new Node<>(15);
        tree.root.right.right = new Node<>(7);

        Tree<Integer> tree2 = new Tree<>();
        tree2.root = new Node<>(10);
        tree2.root.left = new Node<>(9);
        tree2.root.right = new Node<>(11);
        tree2.root.left.left = new Node<>(8);

        Tree<Integer> treeVertical = new Tree<>();
        treeVertical.root = new Node<>(1);
        treeVertical.root.left = new Node<>(2);
        treeVertical.root.right = new Node<>(3);
        treeVertical.root.left.left = new Node<>(4);
        treeVertical.root.left.right = new Node<>(5);
        treeVertical.root.right.left = new Node<>(6);
        treeVertical.root.right.right = new Node<>(7);
        treeVertical.root.right.right.left = new Node<>(8);
        treeVertical.root.right.right.right = new Node<>(9);

//        levelOrder(tree2.root);
//        System.out.println();
//        zigZag(tree2.root);
//        System.out.println();
        printVertical(treeVertical.root, 0);

        char[] in = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char[] pre = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};

        Tree<Character> tempTree = new Tree<>();
//        tempTree.root = creteTree(pre, in, 0);
//        tempTree.levelOrder();
        System.out.println(pathSum(tree.root, 31));
        System.out.println(maxPathSum(tree.root));
        leftView(tree.root, 0);
        System.out.println();
        rightView(tree.root, 0);
        flattenTree(tree.root);
        System.out.println();
        tree.levelOrder();
        System.out.println();
        System.out.println(isBST(tree.root));
        Tree<Integer> tree1 = tree;
        System.out.println("IsIdentical");
        System.out.println(isSame(tree2.root, tree1.root));

        com.practice.practice.practice4.Tree treeNR = new com.practice.practice.practice4.Tree();
        treeNR.root = new com.practice.practice.practice4.Tree.Node(10);
        treeNR.root.left = new com.practice.practice.practice4.Tree.Node(8);
        treeNR.root.right = new com.practice.practice.practice4.Tree.Node(2);
        treeNR.root.left.left = new com.practice.practice.practice4.Tree.Node(3);
        treeNR.root.right.right = new com.practice.practice.practice4.Tree.Node(90);

        connectNextRight(treeNR.root);
        printAllConnectedRight(treeNR.root);
    }

    private static int maxDepth(Node<Integer> root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    static void invertTree(Node<Integer> root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        Node<Integer> left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
    }

    //Recheck, recheck
    static boolean isSame(Node<Integer> root1, Node<Integer> root2) {
        if (root1 != root2) return false;
        if (root1 == null && root2 == null) {
            return true;
        } else
            return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }

    static void levelOrder(Node<Integer> root) {
        if (root == null)
            return;
        Queue<Node<Integer>> queue = new Queue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<Integer> temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    static void zigZag(Node<Integer> root) {
        if (root == null)
            return;
        boolean isLTR = true;
        Stack<Node<Integer>> s1 = new Stack<>(), s2 = new Stack<>();
        s1.add(root);
        while (!s1.isEmpty()) {
            Node<Integer> temp = s1.pop();
            System.out.print(temp.data + " ");
            if (isLTR) {
                if (temp.left != null) {
                    s2.push(temp.left);
                }
                if (temp.right != null) {
                    s2.push(temp.right);
                }
            } else {
                if (temp.right != null) {
                    s2.push(temp.right);
                }
                if (temp.left != null) {
                    s2.push(temp.left);
                }
            }
            if (s1.isEmpty()) {
                isLTR = !isLTR;
                Stack<Node<Integer>> tempStack = s1;
                s1 = s2;
                s2 = tempStack;
            }
        }
    }

    static int lineL = 0, lineR = 0;

    //Redo
    static void printVertical(Node<Integer> root) {
        int l = -1, r = 3;
        printVertical(root, 0);
    }

    static void printVertical(Node<Integer> root, int verticalLine) {
        if (root == null)
            return;
        printVertical(root.left, verticalLine - 1);
        if (lineL == verticalLine) {
            System.out.print(root.data + " ");
            lineL--;
        }
        if (lineR == verticalLine) {
            System.out.print(root.data + " ");
            lineR++;
        }
        printVertical(root.right, verticalLine + 1);
    }

    //Redo pre, in, postOrder without recur
    static void preOrder(Node<Integer> root) {//Root Left Right
        if (root == null)
            return;
        Queue<Node<Integer>> queue = new Queue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
        }
    }

    //Redo for preorder and postorder
    static Node<Character> creteTree(char[] in, char[] pre, int preIndex) {
        Node<Character> node = new Node<>(pre[preIndex]);
//        if (preIndex >= 0) {
        int inIndex = search(in, pre[preIndex]);
        node.left = creteTree(in, pre, inIndex - 1);
        node.right = creteTree(in, pre, inIndex + 1);
//        }
        return node;
    }

    private static int search(char[] in, int val) {
        int i;
        for (i = 0; i < in.length; i++) {
            if (val == in[i]) {
                return i;
            }
        }
        return i;
    }


    static boolean pathSum(Node<Integer> root, int sum) {
        if (root == null && sum == 0)
            return true;
        if (root != null && root.data == sum) {
            return true;
        }
        if (root == null) return false;
        int rem = sum - root.data;
        return pathSum(root.left, rem) || pathSum(root.right, rem);
    }

    static int maxSum;

    static int maxPathSum(Node<Integer> root) {
        if (root == null) return 0;
        int l = maxPathSum(root.left);
        int r = maxPathSum(root.right);
        maxSum = Math.max(maxSum, root.data + l + r);
        return root.data + Math.max(l, r);
    }

    static int leftLevel = 0;

    static void leftView(Node<Integer> root, int num) {
        if (root == null) return;
        if (leftLevel == num) {
            System.out.print(root.data + " ");
            leftLevel--;
        }
        leftView(root.left, num - 1);
        leftView(root.right, num - 1);
    }

    static int rightLevel = 0;

    static void rightView(Node<Integer> root, int currLevel) {
        if (root == null) return;
        if (rightLevel == currLevel) {
            rightLevel++;
            System.out.print(root.data + " ");
        }
        rightView(root.right, currLevel + 1);
        rightView(root.left, currLevel + 1);
    }

    static void flattenTree(Node<Integer> root) {
        if (root == null) return;
        Node<Integer> temp = root.right;
        if (root.left != null) {
            root.right = root.left;
            root.left = null;
            flattenTree(root.right);
        }
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;
        flattenTree(root.right);
    }

    //Redo
    static void connectNextRight(com.practice.practice.practice4.Tree.Node root) {
        if (root == null) return;
        if (root.right != null) {
            if (root.left != null) {
                root.left.nextRight = root.right;
            }
            root.right = getNextRight(root);
        } else {
            if (root.left != null) {
                root.left.nextRight = getNextRight(root);
            }
        }
        connectNextRight(root.left);
        connectNextRight(root.right);
    }

    private static com.practice.practice.practice4.Tree.Node getNextRight(
            com.practice.practice.practice4.Tree.Node root) {
        com.practice.practice.practice4.Tree.Node temp = root.nextRight;
        while (temp != null) {
            if (temp.left != null) return temp.left;
            if (temp.right != null) return temp.right;
            temp = temp.nextRight;
        }
        return null;
    }

    static void printAllConnectedRight(com.practice.practice.practice4.Tree.Node root) {
        if (root == null) return;
        while (root.nextRight != null) {
            System.out.print(root.data + "-NR->");
            root = root.nextRight;
        }
    }

    //WRONG
    static boolean isBST(Node<Integer> root) {
        if (root == null) return true;
        if (root.left != null && root.left.data > root.data) return false;
        if (root.right != null && root.right.data < root.data) return false;
        return isBST(root.left) && isBST(root.right);
    }
}
