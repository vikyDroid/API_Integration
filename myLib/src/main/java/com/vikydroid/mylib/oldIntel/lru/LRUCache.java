package com.vikydroid.mylib.oldIntel.lru;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRUCache {
    private final int cap;
    private final LinkedHashMap<Integer, Integer> map;

    LRUCache(int cap) {
        this.cap = cap;
        map = new LinkedHashMap<>();
    }

    // This method works in O(1)
    public int get(int key) {
        if (map.containsKey(key)) return map.get(key);
        return -1;
    }

    // This method works in O(1)
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() == cap) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }


}
