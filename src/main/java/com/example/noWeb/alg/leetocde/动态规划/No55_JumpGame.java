package com.example.noWeb.alg.leetocde.动态规划;

public class No55_JumpGame {
    // 贪心
    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int reach = 0;
        for (int i = 0; i < nums.length && i<=reach; i++) {
            reach = Math.max(nums[i] + i, reach);
            if (reach >= nums.length - 1)
                return true;

        }
        return false;
    }
    // dp

    /**
     * dp[i] 记录：在i点之前的步数可否达到i点？
     * 其实， j in [0,i)中间有一个到i 就可以了。
     *      DP[i] = DP[j] && (A[j] >= i - j), for all j in [0 ~ i)
     *      DP[dp.length - 1];
     * Time: O(n^2)
     *
     * @param nums
     * @return
     */
    public boolean canJump_DP(int[] nums) {
        //dp[i] 在i点记录，i点之前的步数是否可以走到i点，true或false
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0]  = true;
        for(int i =0;i<len;i++){
            for(int j = 0;j<i;j++){
                //从j到i，需要两个条件：j点可以到达（dp[j]=true）,nums[j]的值要>=j到i的距离
                if(dp[j] && (nums[j]>= i-j)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len-1];
    }
}
