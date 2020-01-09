package com.example.noWeb;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Test {
    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("Test");
        Method method = klass.getMethod("target", int.class);
        method.invoke(null, 0);
    }

    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        for(int i = n-1;i>=0;i--){

            while (!stack.isEmpty()&&nums2[i]>nums2[stack.peek()]){
                stack.pop();
            }
            stack.push(i);
            map.put(nums2[i],stack.empty()?-1:nums2[stack.peek()]);

        }
        for(int i =0;i<nums1.length;i++){
            res[i] = map.get(nums1[i]);
        }
        return  res;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双端队列 保存当前窗口最大值的数组位置
        LinkedList<Integer> queue = new LinkedList<>();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums
        for(int i =0;i<nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，知道满足要求
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek()<= i-k){
                queue.poll();
            }
            // 当窗口长度为k时， 保存当前窗口最大值
            if(i+i>=k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }
}
