package com.example.noWeb.alg.jianzhiOffer;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class T33丑数 {
    public   int GetUglyNumber_Solution(int index) {
        if(index==0)
            return 0;
        if(index==1)
            return 1;
        int[] x= new int[index];
        x[0] = 1;
        int w2 =0,w3=0,w5=0;
        for(int i =1,j=1;i<index;i++){
            int tmp2 = x[w2]*2;
            int tmp3= x[w3]*3;
            int tmp5 = x[w5]*5;
            int t = Math.min(tmp2,Math.min(tmp3,tmp5));
            if(t ==tmp2)
                w2++;
            if(t==tmp3)
                    w3++;
            if(t==tmp5)
                w5++;
            x[i] = t;
        }
        return x[index-1];

    }
}