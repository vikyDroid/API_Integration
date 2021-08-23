package com.vikydroid.mylib.oldIntel.interviews;

import java.util.ArrayList;
import java.util.List;

public class ANZ {
    public static void main(String[] args) {
       // myfun();
    }

    private static List<Integer> myfun(ArrayList<Integer> d, int x) {
        List<Integer> a = new ArrayList<>();
        int s = 0, sg = 0, n = d.size(), c = 1, max = 1;
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(d.get(i) - d.get(i + 1)) > x) {
                s = i + 1;
                c = 1;
            } else {
                c++;
                if (c > max) {
                    max = c;
                    sg = s;
                }
            }
        }
        for (int i = sg; i < sg + max; i++) {
            a.add(d.get(i));
        }

        return a;
    }
}
