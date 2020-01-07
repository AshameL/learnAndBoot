package com.example.noWeb.alg.leetocde.栈;

import java.util.Stack;

// 不算重点题目，比较偏向工程。
public class No71_简化路径 {
    public String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();

        for(int i =0;i<s.length;i++){
            if(!stack.isEmpty() &&s[i].equals("..")){
                stack.pop();
            }else if(!s[i].equals("") && !s[i].equals(".")&& !s[i].equals("..")){
                stack.push(s[i]);
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        StringBuffer res = new StringBuffer();
        for(int i =0;i< stack.size();i++){
            res.append("/" + stack.get(i));
        }
        return res.toString();
    }
}
