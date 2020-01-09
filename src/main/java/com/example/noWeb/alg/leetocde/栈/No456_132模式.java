package com.example.noWeb.alg.leetocde.栈;

import java.util.Stack;

public class No456_132模式 {

    public boolean find132pattern(int[] nums) {
        if(nums.length<3) {
            return false;
        }
        int second = Integer.MIN_VALUE;
        Stack<Integer> stack =new Stack<>();
        stack.add(nums[nums.length-1]);
        for(int i=nums.length-2;i>=0;i--) {

            if (nums[i] < second) {
                return true;
            } else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    second = Math.max(stack.pop(), second);
                }
                stack.push(nums[i]);
            }

        }
        return false;
    }
}
