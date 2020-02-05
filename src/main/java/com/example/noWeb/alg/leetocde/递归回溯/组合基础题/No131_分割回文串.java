package com.example.noWeb.alg.leetocde.递归回溯.组合基础题;

import java.util.ArrayList;
import java.util.List;

public class No131_分割回文串 {
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if(s.length()==0){
            return res;
        }
        List<String> current = new ArrayList<>();
        dfs(s,current,0);
        return res;
    }
    private void dfs(String s,List<String> current,int index){
        if(s.length()==index){
            res.add(new ArrayList<>(current));
        }
        for(int i = index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                current.add(s.substring(index,i+1));
                dfs(s,current,i+1);
                current.remove(current.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s,int start,int end){
        while (start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "aab";
        No131_分割回文串 handler = new No131_分割回文串();
        List<List<String>> list = handler.partition(s);
        System.out.println(list);
    }
}
