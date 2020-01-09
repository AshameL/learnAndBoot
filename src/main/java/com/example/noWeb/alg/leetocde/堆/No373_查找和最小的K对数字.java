package com.example.noWeb.alg.leetocde.堆;

import java.util.*;

public class No373_查找和最小的K对数字 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int sum1 = 0,sum2 = 0;
                for(int i =0;i<o1.size();i++){
                    sum1+=o1.get(i);
                }
                for (int i =0;i<o2.size();i++){
                    sum2+=o2.get(i);
                }
                return sum2-sum1;
            }
        });

        for(int i =0;i< nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[i]);
                if(queue.size()<k){
                    queue.add(list);
                }else {
                    if(queue.comparator().compare(list,queue.peek())>0){
                        queue.remove();
                        queue.add(list);
                    }
                }
            }
        }
        ArrayList<List<Integer>> lists= new ArrayList<>();
        while (!queue.isEmpty()){
            lists.add(0,queue.remove());
        }
        return lists;
    }
}
