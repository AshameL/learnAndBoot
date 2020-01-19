package com.example.noWeb.alg.jianzhiOffer;


public class T49数组中重复的数字 {
    //boolean只占一位，所以还是比较省的
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        boolean[] k = new boolean[length];
        for (int i = 0; i < k.length; i++) {
            if(k[numbers[i]]==true){
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;
        }
        return false;
    }
}