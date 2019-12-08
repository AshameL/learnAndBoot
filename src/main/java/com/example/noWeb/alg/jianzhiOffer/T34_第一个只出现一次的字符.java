package com.example.noWeb.alg.jianzhiOffer;


import java.util.ArrayList;
import java.util.List;

public class T34_第一个只出现一次的字符 {
    public int FirstNotRepeatingChar(String str) {
        int[] words = new int[58];
        for(int i = 0;i<str.length();i++){
            words[((int)str.charAt(i))-65] += 1;
        }
        for(int i=0;i<str.length();i++){
            if(words[((int)str.charAt(i))-65]==1)
                return i;
        }
        return -1;
    }
}