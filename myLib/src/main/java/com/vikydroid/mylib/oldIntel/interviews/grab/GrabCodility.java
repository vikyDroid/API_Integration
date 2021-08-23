package com.vikydroid.mylib.oldIntel.interviews.grab;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class GrabCodility {
    public static void main(String[] args) {
        int[] a = {5, -4, 3, 1, 6};
        System.out.println(ss(a, 3));
    }

    static int ss(int[] a, int m) {
        int max = 0, n = a.length;
        HashMap<Integer, LinkedList<Integer>> s = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int d = (m - (-(a[i] % m))) % m;
            LinkedList<Integer> l = s.getOrDefault(d, new LinkedList<>());
            l.add(a[i]);
            s.put(d, l);
            max = Math.max(max, l.size());
        }
        return max;
    }

    static int ss2(int[] a, int m) {
        // write your code in Java SE 8
        int n = a.length;
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || a[i] == 0 || a[j] == 0) continue;
                int d = Math.abs(a[i] - a[j]);
                if (d % m == 0) {
                    s.add(i);
                    s.add(j);
                }
            }
        }
        int c = s.size();
        if (c > 1) return c;
        return 1;
    }
}