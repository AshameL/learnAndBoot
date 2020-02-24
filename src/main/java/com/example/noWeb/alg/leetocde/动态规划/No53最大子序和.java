package com.example.noWeb.alg.leetocde.动态规划;

public class No53最大子序和 {

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++){
            if(sum <=0){
                sum = nums[i];
            }else {
                sum += nums[i];
            }

            if(max <sum){
                max = sum;
            }

        }
        return max;
    }
}
