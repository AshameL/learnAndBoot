package com.example.learn.local.leetocde.动态规划;

public class No198_HouseRobber {
    /**
     *   best(n) = best(n-2)+nums(n)
     *           OR  best(n-1)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<res.length;i++){
            int t1 = res[i-2]+nums[i];
            int t2 = res[i-1];
            res[i] = Math.max(t1,t2);
        }
        return res[res.length-1];
    }
}
