package com.vikydroid.mylib.oldIntel.practice.practice2.tree;

import com.vikydroid.mylib.oldIntel.practice.practice2.templateT.Queue;
import com.vikydroid.mylib.oldIntel.practice.practice2.templateT.Stack;

public class Tree<T> {
    public Node<T> root;

    //Level Order insertion
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
            return;
        }
        Queue<Node<T>> q = new Queue<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node<T> temp = q.dequeue();
            if (temp.left == null) {
                temp.left = newNode;
                break;
            } else q.add(temp.left);

            if (temp.right == null) {
                temp.right = newNode;
                break;
            } else q.add(temp.right);
        }
    }

    public void addAfter(int after, int data, boolean isLeft) {
        System.out.println("Implementation Pending");
    }

    public void delete(int data) {
        System.out.println("Implementation Pending");
    }

    public void levelOrder2(Node<T> root) {
        if (root == null) return;
        int n = getHeight(root);
        for (int i = 1; i <= n; i++) {
            levelOrder2(root, i);
//            System.out.println();  //To print levels in next line
        }
    }

    private void levelOrder2(Node<T> root, int level) {
        if (root == null) return;
        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            levelOrder2(root.left, level - 1);
            levelOrder2(root.right, level - 1);
        }
    }

    /**
     * Efficient
     */
    public void levelOrder() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<Node<T>> q = new Queue<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node<T> temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
    }

    public void preOrder(Node<T> root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrder() {
        if (root == null) return;
        Stack<Node<T>> s = new Stack<>();
        s.add(root);
        while (!s.isEmpty()) {
            Node<T> temp = s.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null)
                s.push(temp.right);
            if (temp.left != null)
                s.push(temp.left);
        }
    }

    public void inOrder(Node<T> root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void inOrder() {
        if (root == null) return;
        Stack<Node<T>> s = new Stack<>();
        Node<T> curr = root;
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }


    public void postOrder(Node<T> root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void postOrder() {
        if (root == null) return;
        Stack<Node<T>> s1 = new Stack<>(), s2 = new Stack<>();
        s1.add(root);
        while (!s1.isEmpty()) {
            Node<T> popped = s1.pop();
            s2.push(popped);
            if (popped.left != null) {
                s1.add(popped.left);
            }
            if (popped.right != null) {
                s1.add(popped.right);
            }
        }
        while (!s2.isEmpty())
            System.out.print(s2.pop().data + " ");
    }

    public int getHeight(Node<T> root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }


    public boolean isEmpty() {
        return root == null;
    }

    public boolean isIdenticalR(Node<T> root1, Node<T> root2) {
        if (root1 == root2) return true;
        if (root1 != null && root2 != null) {
            return root1.data == root2.data
                    && isIdenticalR(root1.left, root2.left)
                    && isIdenticalR(root1.right, root2.right);
        }
        return false;
    }

    public boolean isIdentical(Node<T> root1, Node<T> root2) {
        if (root1 == null || root2 == null) {
            System.out.println("\nTree is empty");
            return false;
        }
        Queue<Node<T>> q1 = new Queue<>(), q2 = new Queue<>();
        q1.add(root1);
        q2.add(root2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            Node<T> temp1 = q1.poll(), temp2 = q2.poll();
            if (temp1.data == temp2.data) {
                if (temp1.left != null) {
                    q1.add(temp1.left);
                }
                if (temp1.right != null) {
                    q1.add(temp1.right);
                }
                if (temp2.left != null) {
                    q2.add(temp2.left);
                }
                if (temp2.right != null) {
                    q2.add(temp2.right);
                }
            } else return false;
        }
        return q1.isEmpty() && q2.isEmpty();
    }

    public void zigZagTraversal() {
        Stack<Node<T>> currentLevel = new Stack<>(), nextLevel = new Stack<>();
        currentLevel.add(root);
        boolean isLTR = true;
        while (!currentLevel.isEmpty()) {
            Node<T> temp = currentLevel.pop();
            System.out.print(temp.data + " ");
            if (isLTR) {
                if (temp.left != null)
                    nextLevel.add(temp.left);
                if (temp.right != null) {
                    nextLevel.add(temp.right);
                }
            } else {
                if (temp.right != null)
                    nextLevel.add(temp.right);
                if (temp.left != null) {
                    nextLevel.add(temp.left);
                }
            }

            if (currentLevel.isEmpty()) {
                isLTR = !isLTR;
                Stack<Node<T>> tempStack = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tempStack;
            }
        }
    }


    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(7);
        tree.add(6);
        tree.add(5);
        tree.add(4);
        tree.add((int) 'N');

        /*System.out.println("\nPre order : ");
        tree.preOrder(tree.root);
        System.out.println();
        tree.preOrder();

        System.out.println("\nIn order : ");
        tree.inOrder(tree.root);
        System.out.println();
        tree.inOrder();

        System.out.println("\nPost order : ");
        tree.postOrder(tree.root);
        System.out.println();
        tree.postOrder();*/

        System.out.println("\nLevel order : ");
        tree.levelOrder();
        System.out.println();
        tree.zigZagTraversal();
    }
}
