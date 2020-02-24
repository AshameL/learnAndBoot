package com.example.noWeb.alg.jianzhiOffer;


public class T65机器人的运动范围 {
    int count;
    boolean[][]getVisited;
    public int movingCount(int m, int n, int k) {
        if(m <= 0 || n <= 0 || k < 0) return 0;
        getVisited = new boolean[m][n];
        dfs(0,0,m,n,k);
        return count;
    }
    public void dfs(int i,int j,int m,int n,int k){
        if(i < 0 || j < 0 || i >= m || j >= n || getVisited[i][j] == true) return;
        getVisited[i][j] = true;
        if(!canK(i,j,k)) return;
        count++;
        dfs(i + 1,j,m,n,k);
        dfs(i - 1,j,m,n,k);
        dfs(i,j - 1,m,n,k);
        dfs(i,j + 1,m,n,k);
    }
    public boolean canK(int i,int j,int k){
        int sum = 0;
        while(i != 0){
            sum += i % 10;
            i /= 10;
        }
        while(j != 0){
            sum += j % 10;
            j /= 10;
        }
        return sum <= k;
    }


}