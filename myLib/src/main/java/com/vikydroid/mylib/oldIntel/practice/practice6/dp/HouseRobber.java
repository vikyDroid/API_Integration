package com.vikydroid.mylib.oldIntel.practice.practice6.dp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 11, 2};
        System.out.println(profitR(arr, arr.length));

        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(profitM(arr, arr.length, map));

        System.out.println(profitT(arr, arr.length));
        System.out.println(profitTEff(arr, arr.length));
    }

    private static int profitR(int[] arr, int n) {
        if (n <= 0) return 0;
        if (n == 1) return arr[0];
        if (n == 2) return Math.max(arr[0], arr[1]);
        return Math.max(profitR(arr, n - 2) + arr[n - 1], profitR(arr, n - 1));
    }

    private static int profitM(int[] arr, int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n))
            return map.get(n);
        if (n <= 0)
            return 0;
        if (n == 1)
            return arr[0];
        if (n == 2) {
            int max = Math.max(arr[0], arr[1]);
            map.put(n, max);
            return max;
        }
        int max = Math.max(profitM(arr, n - 2, map) + arr[n - 1], profitM(arr, n - 1, map));
        map.put(n, max);
        return max;
    }

    private static int profitT(int[] arr, int n) {
        if (n < 0) throw new ArrayIndexOutOfBoundsException();
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        if (n == 2) return Math.max(arr[0], arr[1]);

        int[] sol = new int[n + 1];
        sol[0] = 0;
        sol[1] = arr[0];
        sol[2] = Math.max(arr[0], arr[1]);
        for (int i = 3; i <= n; i++) {
            sol[i] = Math.max(sol[i - 2] + arr[i - 1], sol[i - 1]);
        }
        return sol[n];
    }

    private static int profitTEff(int[] arr, int n) {
        if (n < 0) throw new ArrayIndexOutOfBoundsException();
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        if (n == 2) return Math.max(arr[0], arr[1]);

        int l = arr[0], r = Math.max(arr[0], arr[1]);
        int max = 0;
        for (int i = 3; i <= n; i++) {
            int x = l + arr[i - 1];
            max = Math.max(x, r);
            l = r;
            r = max;
        }
        return max;
    }
}
