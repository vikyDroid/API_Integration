package com.vikydroid.mylib.oldIntel.practice.practice5.ll;

import org.jetbrains.annotations.NotNull;

public class AddTwoNums {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = getLL(64957);
        LinkedList<Integer> list2 = getLL(48);
        System.out.println(list1);
        System.out.println(list2);
        int z = add(list1, list2);
        LinkedList<Integer> list = getLL(z);
        System.out.println(list);

    }

    private static int add(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        Node<Integer> left = list1.head, right = list2.head;
        int x = 0, y = 0, i = 0;
        while (left != null) {
            x += left.data * Math.pow(10, i);
            i++;
            left = left.next;
        }
        i = 0;
        while (right != null) {
            y += right.data * Math.pow(10, i);
            i++;
            right = right.next;
        }
        return x + y;
    }

    @NotNull
    private static LinkedList<Integer> getLL(int z) {
        LinkedList<Integer> list = new LinkedList<>();
        while (z > 0) {
            list.add(new Node<>(z % 10));
            z /= 10;
        }
        return list;
    }
}
