package com.example.noWeb.alg.leetocde.栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class No496_下一个更大的元素1 {
    // 单调栈 递增的
    // num2 从右往左
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Deque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : nums2[stack.peek()]);
            stack.push(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }


    // 暴力法
    public int[] nextGreaterElement_force(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums1[i]) {
                            res[i] = nums2[k];
                            break;
                        }
                    }
                    break;
                }
            }

        }
        return res;
    }


}
