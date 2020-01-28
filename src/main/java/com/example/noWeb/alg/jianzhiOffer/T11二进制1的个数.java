package com.example.noWeb.alg.jianzhiOffer;

public class T11二进制1的个数 {
     // 很巧妙的方法！！
    public int NumberOf1(int n) {
        int count = 0;
        while(n!= 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
