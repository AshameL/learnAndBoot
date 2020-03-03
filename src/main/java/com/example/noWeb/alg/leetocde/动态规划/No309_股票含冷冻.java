package com.example.noWeb.alg.leetocde.动态规划;

public class No309_股票含冷冻 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int buy = -prices[0];
        int sell = 0;
        int res = 0;

        int cool = 0;

        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, cool - prices[i]);
            cool = Math.max(cool, sell);
            sell = Math.max(sell, buy + prices[i]);
            res = Math.max(res, sell);

        }
        return res;
    }
}
