package com.vikydroid.mylib.oldIntel.test;

import static com.vikydroid.mylib.oldIntel.practice.practice1.constants.MyConstants.swap;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;


public class Sample {
    public static void main(String[] args) {

//        ArrayList<Integer> list = new ArrayList<>(2);
//        list.add(0, 100);
//        list.add(1, 10);
//        list.add(2, 10);
//        for (int i : list) System.out.println(i);
//        System.out.println(Arrays.toString((Integer[]) list.toArray()));
//        System.out.println(Arrays.toString(new char[]{'a', 'a', 'a'}));

        /*List<Item> queue = new LinkedList<>();
        queue.add(new Item(144, 184));
        queue.add(new Item(12, 2));
        Collections.sort(queue);

        for (Item i : queue) System.out.println(i);

        new PriorityQueue<Integer>().poll();*/

        List<String> list = Arrays.asList("RED","BLUE","BLACK","GREEN","BROWN");

        // Java 8 and above:
        List<String> filteredList = list.stream()
                .filter(entry -> entry.startsWith("BL"))
                .collect(Collectors.toList());
        System.out.println(filteredList);
    }

    static class Item implements Comparable<Item> {
        int x, y;

        Item(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int compareTo(@NotNull Item o) {
            return o.x - this.x;
        }
    }

    static int helper(String s) {
        int n = s.length(), i = 0, j = i, count = 0;
        int[] chars = new int[128];
        while (i < n) {
            int local = 0;
//            Arrays.fill(chars, 0);
            while (j < n) {
                if (chars[s.charAt(j)] == 0) {
                    chars[s.charAt(j)]++;
                    j++;
                    local++;
                } else {
                    i++;
                    chars[s.charAt(j)]--;
                    break;
                }
            }
            i++;
            count = Math.max(count, local);
        }
        return count;
    }

    private static void sort01(int[] arr) {
        int n = arr.length, l = 0, r = n - 1;
        int i = 0;
        while (i <= r) {
            if (arr[i] == 0) {
                swap(arr, i, l);
                l++;
                i++;
            } else if (arr[i] == 1) {
                i++;
            } else if (arr[i] == 2) {
                swap(arr, i, r);
                r--;
            } else {
                System.out.println(i);
                i++;
            }
        }
    }

    static int solve(int A, ArrayList<Integer> B) {
        int sum = 0;
        int count = 0;
        int result = 0;
        int cummulativeSum = 0;

        for (Integer i : B) {
            sum += i;
        }

        if (sum % 3 != 0) {
            return 0;
        }

        for (int i = 0; i < A; i++) {
            cummulativeSum += B.get(i);

            if (cummulativeSum == ((2 * sum) / 3) && i >= 1 && i <= A - 2) {
                result += count;
            }

            if (cummulativeSum == sum / 3) {
                count += 1;
                // continue;
            }

        }
        return result;
    }

    private static int maxArr(ArrayList<Integer> A) {
        int n = A.size(), max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                max = Math.max(max, getSum(A, i, j));
            }
        }
        return max;
    }

    static int getSum(ArrayList<Integer> A, int i, int j) {
        return Math.abs(A.get(i) - A.get(j)) + Math.abs(i - j);
    }

    private static int[] getSortedMergedArr(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0, n1 = arr1.length, n2 = arr2.length;
        int[] res = new int[n1 + n2];
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                res[k] = arr1[i];
                i++;
            } else {
                res[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            res[k++] = arr1[i++];
        }
        while (j < n2) {
            res[k++] = arr2[j++];
        }
        Math.floor(Double.MAX_VALUE);


        return res;
    }

    private static void extracted(int[] arr) {
        int first = arr[0], second = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                second = arr[i];
            }
        }
        System.out.println(second);
    }
}
