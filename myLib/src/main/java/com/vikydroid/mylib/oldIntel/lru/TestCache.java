package com.vikydroid.mylib.oldIntel.lru;

public class TestCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.set(94, 16);
        lruCache.set(93, 87);
        lruCache.set(63, 22);
        lruCache.set(60, 91);
        lruCache.set(41, 27);
        lruCache.set(63, 1111);
        lruCache.set(23, 1111);
        System.out.println(lruCache.get(73));
        System.out.println(lruCache.get(12));
        System.out.println(lruCache.get(68));
    }
}
