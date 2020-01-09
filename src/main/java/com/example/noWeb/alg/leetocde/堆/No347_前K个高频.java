package com.example.noWeb.alg.leetocde.堆;

import java.util.*;

public class No347_前K个高频 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> count = new HashMap<>();
        for(int n:nums){
            count.put(n,count.getOrDefault(n,0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2)->count.get(n1)-count.get(n2));

        for(int n:count.keySet()){
            heap.add(n);
            if(heap.size()>k){
                heap.poll();
            }
        }
        //
        ArrayList<Integer> topK = new ArrayList<>();

        while (!heap.isEmpty()){
            topK.add(heap.poll());
        }
        Collections.reverse(topK);
        return topK;
    }
}
