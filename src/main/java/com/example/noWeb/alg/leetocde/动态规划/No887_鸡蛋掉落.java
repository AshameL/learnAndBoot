package com.example.noWeb.alg.leetocde.动态规划;

public class No887_鸡蛋掉落 {
    public int superEggDrop(int K, int N) {
        int[][] status = new int[N+1][K+1]; // n次操作，k个蛋
        int i = 0;
        while (status[i][K]<N){
            i++;
            for(int k = 1;k<=K;k++){
                // status[i-1][k-1] 蛋没碎，status[i-1][k]蛋碎了；1 当前这次
                status[i][k]= status[i-1][k-1]+status[i-1][k]+1;// k个蛋，i次操作。

            }
        }
        return i;
    }
}
