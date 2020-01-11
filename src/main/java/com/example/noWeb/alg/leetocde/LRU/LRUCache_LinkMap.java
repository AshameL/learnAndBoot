package com.example.noWeb.alg.leetocde.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_LinkMap extends LinkedHashMap<Integer,Integer> {
    private int capacity;

    public LRUCache_LinkMap(int capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    public int get(int key){
        return super.getOrDefault(key,-1);
    }

    public void put(int key,int value){
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return size()>capacity;
    }
}