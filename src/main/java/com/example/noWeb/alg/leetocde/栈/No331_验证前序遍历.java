package com.example.noWeb.alg.leetocde.栈;

import java.util.Stack;

public class No331_验证前序遍历 {

    public boolean isValidSerialization(String preorder) {
        String[] str = preorder.split(",");
        if (str.length == 0) {
            return false;
        }
        Stack<String> stack = new Stack<>();
        for (String s : str) {
            stack.push(s);
            while (stack.size()>=3 ){
                String t1 = stack.pop();
                String t2 = stack.pop();
                if(!t1.equals("#") || !t2.equals("#")){
                    stack.push(t2);
                    stack.push(t1);
                    break;
                }
                if(stack.peek().equals("#")){
                    return false;
                }
                stack.pop();

                stack.push("#");
            }

        }
        return stack.size()== 1 && stack.peek().equals("#");
    }
}
