package com.vikydroid.mylib.oldIntel.practice.practice5.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    public static void main(String[] args) {
        String[] arr = {"cat", "dog", "tac", "god", "act"};
        StrPos[] list = new StrPos[arr.length];
        for (int i = 0; i < arr.length; i++) {
            list[i] = new StrPos(arr[i], i);
        }
        HashMap<String, ArrayList<StrPos>> map = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            char[] temp = list[i].s.toCharArray();
            Arrays.sort(temp);
            list[i].s = new String(temp);
            ArrayList<StrPos> lllll = map.getOrDefault(list[i].s, new ArrayList<>());
            lllll.add(list[i]);
            map.put(list[i].s, lllll);
        }

        for (String key : map.keySet()) {
            ArrayList<StrPos> llll = map.get(key);
            for (StrPos s : llll) {
                System.out.print(arr[s.pos] + " ");
            }
        }

    }

    static class StrPos {
        String s;
        int pos;

        StrPos(String s, int pos) {
            this.s = s;
            this.pos = pos;
        }
    }

}
