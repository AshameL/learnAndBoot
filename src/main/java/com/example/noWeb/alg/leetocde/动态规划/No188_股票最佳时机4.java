package com.example.noWeb.alg.leetocde.动态规划;

public class No188_股票最佳时机4 {
    // 暴力法
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][] local = new int[n][k + 1];
        int[][] global = new int[n][k + 1];

        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i = 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1], local[i-1][j-1] )+diff;
                global[i][j] = Math.max(global[i-1][j],local[i][j]);
            }
        }
        return global[n-1][k];
    }

}
