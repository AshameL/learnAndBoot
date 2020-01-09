package com.example.noWeb.alg.leetocde.堆;

import java.util.PriorityQueue;

public class No264_丑数2 {
    public int nthUglyNumber(int n) {
        if (n<=6) {
            return n;
        }
        int[] uglyNum = new int[n];
        uglyNum[0] = 1;
        int m2 = 0,m3=0,m5=0;
        for(int i = 1;i<n;i++){
            uglyNum[i]=Math.min(uglyNum[m2]*2,Math.min(uglyNum[m3]*3,uglyNum[m5]*5));
            if (uglyNum[m2]*2==uglyNum[i]) {
                m2++;
            }
            if (uglyNum[m3]*3==uglyNum[i]) {
                m3++;
            }
            if (uglyNum[m5]*5==uglyNum[i]) {
                m5++;
            }
        }
        return uglyNum[n-1];
    }

    public static void main(String[] args) {
        No264_丑数2 n = new No264_丑数2();
        int res = n.nthUglyNumber(10);
        System.out.println(res);
    }
}
