package com.vikydroid.mylib.oldIntel.practice.practice2.queue;

import java.util.*;

public class KMostFrequent {

    public List<String> kMostFrequent(String[] arr, int k) {
        int n = arr.length;
        Map<String, Integer> map = new HashMap<>();
        for (String key : arr) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            if (!o1.getValue().equals(o2.getValue())) return o1.getValue() - o2.getValue();
            return o1.getKey().compareTo(o2.getKey());
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(entry);
            if (queue.size() > k)
                queue.poll();
        }
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll().getKey());
        }
        Collections.reverse(res);
        return res;

    }

    public static void main(String[] args) {
        String[] arr = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 2;
        System.out.println(Arrays.toString(new KMostFrequent().kMostFrequent(arr, k).toArray()));
    }
}
