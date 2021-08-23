package com.vikydroid.mylib.oldIntel.practice.codechef.w2;

import java.util.Scanner;
import java.util.Stack;

public class MatchedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
            if (arr[i] == 1) s.append('(').append(' ');
            else s.append(')').append(' ');
        }
        System.out.println(s);
        Stack<Integer> stack = new Stack<>();
        int count = 0, tempCount = 0, start = 0, tempStart = 0;
        for (int i = 0; i < N; i++) {
            tempStart = i;
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else if (stack.peek() == 1 && arr[i] == 2) {
                stack.pop();
                tempCount += 2;
                if (stack.isEmpty()) {
                    count = Math.max(count, tempCount);
                    tempCount = 0;
                    start = tempStart + 1;
                }
            } else stack.push(arr[i]);
        }
        System.out.println(count + " " + start);
    }
}
