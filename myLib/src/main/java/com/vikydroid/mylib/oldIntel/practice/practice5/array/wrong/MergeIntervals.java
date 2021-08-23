package com.vikydroid.mylib.oldIntel.practice.practice5.array.wrong;

import com.practice.practice.practice2.templateT.Stack;

import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        Integer[][] arr = {{6, 8}, {1, 9}, {2, 4}, {4, 7}};
        /*for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i][arr[i].length - 1] > arr[j][0]
                        && arr[i][arr[i].length - 1] < arr[j][arr[j].length - 1]) {
                    System.out.println("(" + arr[i][0] + "," + arr[j][arr[j].length - 1] + ")");
                }
            }
        }*/
        mergeInterval(arr);
    }

    static void mergeInterval(Integer[][] arr) {
        Stack<Integer[]> stack = new Stack<>();
        for (Integer[] integers : arr) {
            if (stack.isEmpty()) {
                stack.push(integers);
            } else {
                Integer[] temp = stack.pop();
                if (temp[1] > integers[0] && temp[1] < integers[1]) {
                    temp[1] = integers[1];
                    stack.push(temp);
                } else {
                    stack.push(temp);
                    stack.push(integers);
                }
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(Arrays.toString(stack.pop()));
        }
    }
}
