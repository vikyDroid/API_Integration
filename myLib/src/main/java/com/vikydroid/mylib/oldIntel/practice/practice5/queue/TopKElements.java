package com.vikydroid.mylib.oldIntel.practice.practice5.queue;

import java.util.*;

public class TopKElements {
    public static void main(String[] args) {
        String[] str = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;


        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            map.put(str[i], map.getOrDefault(str[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
            if (a.getValue() != (int) b.getValue()) return a.getValue() - b.getValue();
            else return b.getKey().compareTo(a.getKey());
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(entry);
            if (queue.size() > k) queue.poll();
        }

        ArrayList<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll().getKey());
        }
        Collections.reverse(list);

        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}
