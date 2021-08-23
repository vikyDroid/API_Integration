package com.vikydroid.mylib.oldIntel.interviews;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Paytm {
    public static void main(String[] args) {
        ques2();

    }

    private static void ques2() {
        String s = ")()())";
        int countOpening = 0, max = 0, pairs = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
//                if (countOpening == 0) pairs = 0;
                countOpening++;
                pairs=0;
            } else if (s.charAt(i) == ')') {
                if (countOpening == 0) {
                    pairs = 0;
                } else {
                    countOpening--;
                    pairs += 2;
                }
                max = Math.max(pairs, max);
            }
        }
        System.out.println(max);
    }

    private static void ques1() {
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        ht.put(1, 1);

        HashMap<String, Integer> emotcon = new HashMap<>();
        new ConcurrentHashMap<Integer, Integer>().put(1, 2);

        new LinkedHashMap<Integer, Integer>().put(1, 2);

        new TreeMap<Integer, Integer>().put(1, 2);
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(null);
        Iterator<Integer> iterator = new LinkedList<Integer>().descendingIterator();

        emotcon.put(":)", 1);
        emotcon.put(":-)", 1);
        emotcon.put(":/", 2);
        emotcon.put(":(", 3);
        emotcon.put(":-(", 4);
        String text = "How is it going? ::::)):) you are almost done :-):-(!";

        parseText(text, emotcon);
    }

    static void parseText(String text, HashMap<String, Integer> map) {
        int n = text.length();
        char[] chars = text.toCharArray();
        for (int i = 0; i < n - 3; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + 3; j++) {
                sb.append(chars[j]);
                if (map.containsKey(sb.toString())) {
                    System.out.print(i + "," + map.get(sb.toString()) + "," + sb.toString().length());
                    System.out.println();
                }
            }
        }
    }
}
