package com.example.noWeb;

import com.example.noWeb.alg.leetocde.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Method;
import java.util.*;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0;i<nums.length;i++){
            queue.add(nums[i]);
            if(queue.size()==k){
                queue.poll();
            }
        }
        return queue.poll();
    }

}
