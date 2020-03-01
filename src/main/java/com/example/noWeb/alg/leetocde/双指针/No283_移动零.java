package com.example.noWeb.alg.leetocde.双指针;

import java.util.Arrays;

public class No283 {
    public static void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        int n = nums.length;
        while (i < nums.length && j < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            j = Math.max(i, j);
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (i < n && j < n) {
                System.out.println("i j 互换"+nums[i]+nums[j]);
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        System.out.println(Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
