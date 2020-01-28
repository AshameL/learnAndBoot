package com.example.noWeb.alg.leetocde.堆;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class No239_滑动窗口最大值 {
    // 堆
    public int[] maxSlidingWindow_1(int[] nums, int k) {
        if (nums.length <= k) return new int[0];

        int[] res = new int[nums.length-k +1];
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            if(q.size() == k){
                q.remove(nums[i-k]);
            }
            q.add(nums[i]);
            if(i>=k-1){
                res[i+1-k] = q.peek();
            }
        }
        return res;
    }
    // 单调队列
    public int[] maxSlidingWindow_2(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No239_滑动窗口最大值 n = new No239_滑动窗口最大值();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = n.maxSlidingWindow_1(nums,k);
        for(int i :res){
            System.out.print(i+" ");
        }
    }
}
