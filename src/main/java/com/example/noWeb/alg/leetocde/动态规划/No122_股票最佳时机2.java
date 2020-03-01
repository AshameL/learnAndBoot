package com.example.noWeb.alg.leetocde.动态规划;

public class No122_股票最佳时机2 {
    public int maxDiff(int[] nums) {
        int res = 0;
        int minV= nums[0];//前i-1天的最小值

        for(int i = 1;i<nums.length;i++){
            res = Math.max(res,nums[i] - minV);
            minV = Math.min(minV,nums[i]);
        }

        return res;
    }
}
