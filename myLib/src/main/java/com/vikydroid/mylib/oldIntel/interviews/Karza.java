package com.vikydroid.mylib.oldIntel.interviews;


import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Stack;

public class Karza {
    public static void main(String[] args) {
        int[] arr = {26, 34, 45, 22, 19, 500};
        // 5, 91, 22, 54, 43, 62

        String s = "{a + (b-c)}";

        //3*3
        //n/2
        //O(logn)
        int[][] mat = {
                {0, 1, 3},//0
                {5, 7, 10},//1
                {9, 14, 95} //2
        };
        int k = 95;
        System.out.println(Arrays.toString(find(mat, k, 0, 0, mat.length - 1, mat[0].length - 1)));

//        System.out.println(callFun(s));
    }

    private static int[] find(int[][] mat, int k, int x1, int y1, int x2, int y2) {
        int[] res = new int[2];
        int midx = x1 + (x2 / 2);
        int midy = y1 + (y2 / 2);
        int[] i1 = getIndex(mat, k, x1, y1, x2, y2);
        if (i1 != null) return i1;
        if (!(x1 >= 0 && y1 >= 0) && !(x2 < mat.length && y2 < mat[0].length)) {
            return new int[]{0, 0};
        }
        int i = mat[midx][midy];
        if (i == k) {
            res[0] = midx;
            res[1] = midy;
        } else if (k < i) {
            return find(mat, k, x1, y1, midx, midy);
        } else
            return find(mat, k, midx, midy, x2, y2);
        return res;
    }

    @Nullable
    private static int[] getIndex(int[][] mat, int k, int x1, int y1, int x2, int y2) {
        if (x1 == 0 && y1 == 0 && x2 == 1 && y2 == 1) {
            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    if (mat[i][j] == k)
                        return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static boolean callFun(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else if (c == '}') {
                char p = stack.pop();
                if (p != '{') return false;
            } else if (c == ')') {
                char p = stack.pop();
                if (p != '(') return false;
            } else if (c == ']') {
                char p = stack.pop();
                if (p != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    private static int getMin(int[] arr) {
        int a = arr[0], n = arr.length, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (arr[i] > a) {
                c = b;
                b = a;
                a = arr[i];
            } else if (arr[i] > b) {
                c = b;
                b = arr[i];
            } else if (arr[i] > c) {
                c = arr[i];
            }
        }
        return c;
    }
}
