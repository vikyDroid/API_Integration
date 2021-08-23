package com.vikydroid.mylib.oldIntel.practice.practice2.queue;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArr {
    public int[] mergeKSorted(int[][] arr) {
        int n = arr.length, total = 0;
        PriorityQueue<ArrayContainer> queue = new PriorityQueue<>();
        for (int[] ints : arr) {
            queue.add(new ArrayContainer(ints, 0));
            total += ints.length;
        }
        int[] res = new int[total];
        int i = 0;
        while (!queue.isEmpty()) {
            ArrayContainer ac = queue.remove();
            res[i++] = ac.arr[ac.index];
            if (ac.index < ac.arr.length - 1) {
                queue.add(new ArrayContainer(ac.arr, ac.index + 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] arr3 = {0, 9, 10, 11};

        System.out.println(Arrays.toString(
                new MergeKSortedArr().mergeKSorted(new int[][]{arr1, arr2, arr3})));
    }

    class ArrayContainer implements Comparable<ArrayContainer> {
        int[] arr;
        int index;

        public ArrayContainer(int[] arr, int i) {
            this.arr = arr;
            index = i;
        }

        @Override
        public int compareTo(@NotNull ArrayContainer o) {
            return this.arr[this.index] - o.arr[o.index];
        }
    }

}

