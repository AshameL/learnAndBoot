package com.example.noWeb.alg.jianzhiOffer;


import java.util.ArrayList;

public class T42和为S的两个数字 {
    // 左右夹逼
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array==null||array.length<2){
            return list;
        }
        int i =0,j=array.length-1;
        while (i<j){
            if(array[i]+array[j]==sum){
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }else if(array[i]+array[j]>sum){
                j--;
            }else {
                i++;
            }
        }
        return list;
    }
}