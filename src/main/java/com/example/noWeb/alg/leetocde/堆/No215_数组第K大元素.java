package com.example.noWeb.alg.leetocde.堆;

import com.example.noWeb.alg.leetocde.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No215_数组第K大元素 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1,n2)->n1-n2);
        for(int i:nums){
            priorityQueue.add(i);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }
}
