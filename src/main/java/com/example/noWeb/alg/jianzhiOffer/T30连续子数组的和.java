package com.example.noWeb.alg.jianzhiOffer;

import java.util.ArrayList;
import java.util.TreeSet;


public class T30连续子数组的和 {
    //https://www.nowcoder.com/profile/844008/codeBookDetail?submissionId=1519441
    public int FindGreatestSumOfSubArray(int[] array) {
        int n = array.length;
        int[] memo = new int[n];
        int res = array[0];
        memo[0] = array[0];
        for(int i =1;i<n;i++){
            memo[i] = Math.max(array[i]+memo[i-1],array[i]);
            res = Math.max(res,memo[i]);
        }
        return res;
    }
}
