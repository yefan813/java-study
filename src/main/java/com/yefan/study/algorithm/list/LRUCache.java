package com.yefan.study.algorithm.list;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yefan
 */
public class LRUCache extends LinkedHashMap<Integer,Integer> {
    private int capacity;

    public LRUCache(int initialCapacity) {
        super(initialCapacity,0.75f,true);
        this.capacity = initialCapacity;
    }

    /**
     * remove oldest
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.removeEldestEntry(eldest);
    }

    public int get(int key){
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }
}
