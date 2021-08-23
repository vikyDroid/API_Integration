package com.vikydroid.mylib.oldIntel.practice.practice2.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergerOverlappingIntervals {
    public static void main(String[] args) {
        Interval[] arr = {
                new Interval(1, 3),
                new Interval(5, 7),
                new Interval(6, 8),
                new Interval(2, 4)};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, Comparator.comparingInt(o -> o.start));
        System.out.println(Arrays.toString(arr));
        new MergerOverlappingIntervals().mergeOverlappingIntervals2(arr);
    }

    public void mergeOverlappingIntervals(Interval[] arr) {
        int n = arr.length;
        Stack<Interval> stack = new Stack<>();
        stack.add(arr[0]);
        for (int i = 1; i < n; i++) {
            Interval top = stack.peek();
            Interval curr = arr[i];
            if (top.end < curr.start) {
                stack.push(curr);
            } else if (top.end < curr.end) {
                top.end = curr.end;
                stack.pop();
                stack.push(top);
            }
        }
        while (!stack.isEmpty()) {
            Interval top = stack.pop();
            System.out.println("[" + top.start + "," + top.end + "]");
        }
    }

    public void mergeOverlappingIntervals2(Interval[] arr) {
        int n = arr.length;
        int index = 0;

        for (int j = 1; j < n; j++) {
            if (arr[index].end > arr[j].start) {
                if (arr[index].start < arr[j].end) {
                    System.out.println("[" + arr[index].start + "," + arr[j].end + "]");
                }
            } else {

            }
            index++;
        }
    }

    public static class Interval {
        int start, end;

         Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}


