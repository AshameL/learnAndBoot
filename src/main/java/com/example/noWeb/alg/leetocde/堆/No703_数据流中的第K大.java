package com.example.noWeb.alg.leetocde.堆;

import java.util.PriorityQueue;

public class No703_数据流中的第K大 {
    int size;
    private PriorityQueue<Integer> q;

    public No703_数据流中的第K大(int k, int[] nums) {
        size = k;
        q = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (q.size()<size){
            q.add(val);
        }else if(q.peek() <val){
            q.poll();
            q.add(val);
        }
        return q.peek();
    }
}
