package com.example.noWeb.alg.jianzhiOffer;

import com.example.noWeb.alg.leetocde.TreeNode;

import java.util.ArrayList;
import java.util.TreeSet;



public class T27字符串的排列 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str==null||str.length()==0)
            return result;
        char[] chars= str.toCharArray();
        TreeSet<String> temp = new TreeSet<>();
        Permutation(chars,0,temp);
        result.addAll(temp);
        return result;
    }

    private void Permutation(char[] chars, int begin, TreeSet<String> result) {
        if(chars == null|| chars.length==0||begin<0||begin>chars.length-1){
            return;
        }
        if(begin == chars.length-1){
            result.add(String.valueOf(chars));
        }else {
            for(int i = begin;i< chars.length;i++){
                swap(chars,begin,i);
                Permutation(chars,begin+1,result);
                swap(chars,begin,i);
            }
        }

    }

    private void swap(char[] chars, int a, int b) {
        char t = chars[a];
        chars[a] = chars[b];
        chars[b] = t;
    }

}
