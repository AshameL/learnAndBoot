package com.example.noWeb.alg.jianzhiOffer;


import java.util.ArrayList;

public class T67N个骰子 {
    public int[] numberOfDice_dp(int n) {
        //f[i][j]  前i次，和为j的
        int[][] f = new int[n+1][6*n+1];
        f[0][0] = 1;
        for(int i =1;i<=n;i++){
            for(int j=1;j<=i*6;j++){
                for(int k = 1;k<=Math.min(j,6);k++){
                    f[i][j] += f[i-1][j-k];
                }
            }
        }
        int[] res = new int[n*5+1];
        for(int i = n,j=0;i<=n*6;i++){
            res[j] = f[n][i];
            j++;
        }
        return res;
    }



    public int[] numberOfDice(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int[][] mono = new int[n + 1][6 * n + 1];
        for (int i = n; i <= n * 6; i++) {
            res.add(dfs(n, i, mono));
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private Integer dfs(int n, int sum, int[][] mono) {
        if (sum < 0) return 0;
        if (n == 0 && sum == 0) return 1;
        if (mono[n][sum] != 0) {
            return mono[n][sum];
        }
        int res = 0;
        for (int i = 1; i <= 6; i++) {
            res += dfs(n - 1, sum - i, mono);
            mono[n - 1][sum - i] = res;

        }
        return res;
    }

    public static void main(String[] args) {
        T67N个骰子 t = new T67N个骰子();
        int[] obj = t.numberOfDice_dp(5);
        for (int i : obj) {
            System.out.println(i);
        }
    }
}