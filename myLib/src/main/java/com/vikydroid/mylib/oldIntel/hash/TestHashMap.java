package com.vikydroid.mylib.oldIntel.hash;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(null, 2);
        map.put(null, null);

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(null, null);

        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("null", 0);

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("null", null);

    }
}
