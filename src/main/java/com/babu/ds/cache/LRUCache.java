package com.babu.ds.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public V getValue(K key) {
        return super.getOrDefault(key, null);
    }

    public void putValue(K key, V value) {
        super.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.putValue(1, "A");
        cache.putValue(2, "B");
        cache.putValue(3, "C");
        System.out.println(cache.keySet()); // [1, 2, 3]

        cache.getValue(2); // Access key 2
        cache.putValue(4, "D"); // Evicts key 1 (LRU)
        System.out.println(cache.keySet()); // [3, 2, 4]
    }
}
