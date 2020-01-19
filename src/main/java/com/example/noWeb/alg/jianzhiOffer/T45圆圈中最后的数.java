package com.example.noWeb.alg.jianzhiOffer;


public class T45圆圈中最后的数 {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        } else {
            return (LastRemaining_Solution(n-1,m)+m)%n;
        }
    }

}