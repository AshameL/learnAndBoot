package com.example.noWeb.alg.jianzhiOffer;


public class T66剪绳子 {
    public static int cuttingRope(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int res = 0;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i ; j++) {
                res = Math.max(res, dp[j] * dp[i - j]);
            }
            dp[i] = res;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = cuttingRope(10);
        System.out.println(res);
    }
}