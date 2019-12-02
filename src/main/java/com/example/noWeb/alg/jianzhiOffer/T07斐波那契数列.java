package com.example.noWeb.alg.jianzhiOffer;

public class T07斐波那契数列 {
    public int Fibonacci(int n) {
        if(n<=1)
            return n;
        int[] arr  = new int[n+1];
        arr[0]=0;
        arr[1]=1;
        arr[2]=1;
        for(int i=3;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}
