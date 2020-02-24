package com.example.noWeb.alg.leetocde.堆;

import java.util.PriorityQueue;

public class No1046_最后一块石头的重量 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int i : stones)
            pq.offer(i);
        while (pq.size() >= 2) {

            int x = pq.poll();
            int y = pq.poll();
            if (x > y)
                pq.offer(x - y);
        }
        return pq.size() == 1 ? pq.peek() : 0;
    }
}
