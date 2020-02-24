package com.example.noWeb.alg.leetocde.贪心;

public class No343_整数拆分 {
    public int integerBreak(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        if(n==3)return 2;
        int[] dp = new int[n+1];
        dp[1] = 1;

        for(int i =2;i<=n;i++){
            dp[i] = i;
            for(int j = 1;j<i;j++){
                dp[i] = Math.max(dp[i],j*dp[i-j]);
            }
        }
        return dp[n];
    }
}
