package com.example.noWeb.alg.leetocde.动态规划.背包;

import java.util.Scanner;

/**
 * f[i][j] 只看前i个物品，总体积是j的情况下，总价值最大是多少。
 * result= max{f[n][0~v]}
 * f[i][j] =
 * 1. 不选第i个物品，    = f[i-1][j]
 * 2. 选第i个物品        =f[i-1][j-v[i]] + w[i]
 * f[i][j] = max{1,2}
 */
public class No_01backpack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        for (int i = 0; i < N; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        //##################################### 正文 int[0][V]
        int[][] dp = new int[N][V + 1];
        // 初始化第0个物品时的价值
        for (int i = 0; i <= V; i++) {
            if (i < v[0]) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = w[0];
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= V; i++) {
            res = Math.max(res, dp[N - 1][i]);
        }
        System.out.println(res);
    }
}
