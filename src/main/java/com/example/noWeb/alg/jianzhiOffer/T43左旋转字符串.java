package com.example.noWeb.alg.jianzhiOffer;


import java.util.ArrayList;

public class T43左旋转字符串 {
    //        for(int i = 0, j = n - 1; i < j; ++i, --j) swap(str[i], str[j]);
    //        for(int i = n, j = len - 1; i < j; ++i, --j) swap(str[i], str[j]);
    //        for(int i = 0, j = len - 1; i < j; ++i, --j) swap(str[i], str[j]);
    public String LeftRotateString(String str,int n) {
        if(str.length()==0){
            return str;
        }
        StringBuilder builder = new StringBuilder(str);
        StringBuilder builder1 = new StringBuilder(str);
        StringBuilder builder2 = new StringBuilder();

        builder.delete(0,n);
        builder1.delete(n,str.length());
        builder2.append(builder.toString()).append(builder1.toString());
        return builder2.toString();
    }
}