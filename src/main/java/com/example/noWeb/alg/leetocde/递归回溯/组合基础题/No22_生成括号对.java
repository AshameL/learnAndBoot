package com.example.noWeb.alg.leetocde.递归回溯.组合基础题;

import java.util.ArrayList;
import java.util.List;

public class No22_生成括号对 {
    
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n,result,new StringBuilder(),0,0,0);
        return result;
    }

    private void dfs(int n, List<String> result, StringBuilder cur, int start, int left, int right) {
        if(start >= n*2){
            result.add(new String(cur));
        }
        if(left < n){
            dfs(n,result,cur.append("("),start+1,left+1,right);
            cur.deleteCharAt(cur.length()-1);
        }
        if(right<left){
            dfs(n,result,cur.append(")"),start+1,left,right+1);
            cur.deleteCharAt(cur.length()-1);
        }
    }

    public static void main(String[] args) {
        No22_生成括号对 cur = new No22_生成括号对();
        List<String > res = cur.generateParenthesis(3);
        System.out.println(res);
    }

}
