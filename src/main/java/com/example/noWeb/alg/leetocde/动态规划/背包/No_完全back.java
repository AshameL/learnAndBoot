package com.example.noWeb.alg.leetocde.动态规划.背包;

import java.util.Scanner;

public class No_完全back {
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
        //########################################################
        /*
         f[i] 表示总体积是i的情况下，最大价值是多少。
         res = max(f[0....m])

        */
        int res = solution(w,v,N,V);
        System.out.println(res);
    }
    private static int solution(int[] w,int[] v,int n,int V){
        int dp[][] = new int[n][V+1];
        for(int i = 0;i<=V;i++){
            dp[0][i] = i/w[0]*v[0];
        }
        int max = 0;
        for(int i =1;i<n;i++){
            for(int j = 1;j<=V;j++){
                for(int k = 0;k*w[i]<=j;k++){
                    int t = k*v[i] +dp[i-1][j-k*w[i]];
                    if(max <t){
                        max = t;
                    }
                }
                dp[i][j] = max;
                max = 0;
            }
        }
        return dp[n-1][V];
    }

}
