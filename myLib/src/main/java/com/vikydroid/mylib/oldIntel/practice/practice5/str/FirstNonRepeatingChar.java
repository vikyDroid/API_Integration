package com.vikydroid.mylib.oldIntel.practice.practice5.str;

import java.util.HashMap;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String s = "GeeksforGeeks";
        firstNonRepeatingChar(s);
    }

    //O(n) using arr
    private static void firstNonRepeatingChar(String s) {
        int[] arr = new int[256];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)] == 1) {
                System.out.println(s.charAt(i));
                return;
            }
        }
    }

    //O(n) using HashMap
    private static void firstNonRepeatingChar2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                System.out.println(s.charAt(i));
                return;
            }
        }
    }
}
