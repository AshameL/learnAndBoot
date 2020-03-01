package com.example.noWeb.alg.leetocde.动态规划;

// 类似  714. 买卖股票的最佳时机含手续费
public class No123_股票最佳时机3 {

    public int maxProfit(int[] prices) {
        if(prices.length<2){
            return 0;
        }
        int buy =-prices[0];
        int sell = 0;
        int res = 0;
        for(int i = 1;i<prices.length;i++){
            buy = Math.max(buy,sell-prices[i]);
            sell =Math.max(sell,buy+prices[i]);
            res = Math.max(res,sell);

        }
        return  res;
    }
}
