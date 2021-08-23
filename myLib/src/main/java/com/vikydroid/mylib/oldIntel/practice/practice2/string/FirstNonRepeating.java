package com.vikydroid.mylib.oldIntel.practice.practice2.string;

import java.util.HashMap;

public class FirstNonRepeating {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        int times = 4;
        System.out.println(new FirstNonRepeating().firstNonRepeatingChar2(str, times));
        System.out.println(str.charAt(str.charAt(0)));

    }

    public char firstNonRepeatingChar(String str) {
        char[] c = str.toCharArray();
        int n = c.length;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char key = c[i];
            if (hm.containsKey(key)) {
                hm.put(key, hm.get(key) + 1);
            } else {
                hm.put(key, 1);
            }
        }

        for (int i = 0; i < n; i++) {
            char key = c[i];
            if (hm.get(key) == 1) {
                return key;
            }
        }

        return '!';
    }

    public char firstNonRepeatingChar2(String str, int times) {
        char[] c = str.toCharArray();
        int n = c.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (c[i] == c[j]) {
                    break;
                } else if (j == n - 1) {
                    count++;
                    if (count == times) {
                        return c[i];
                    }
//                    return c[i];
                }
            }
        }
        return '!';
    }

}
