package com.example.noWeb.alg.leetocde.栈;

import java.util.Stack;

public class No150_逆波兰 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            int res;
            if (tokens[i].equals("+")) {
                res = stack.pop() + stack.pop();
                stack.push(res);
            } else if (tokens[i].equals("-")) {
                int r1 = stack.pop();
                int r2 = stack.pop();
                res = r2 - r1;
                stack.push(res);
            } else if (tokens[i].equals("*")) {
                res = stack.pop() * stack.pop();
                stack.push(res);
            } else if (tokens[i].equals("/")) {
                int r1 = stack.pop();
                int r2 = stack.pop();
                res = r2 / r1;
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] chars = {"4", "13", "5", "/", "+"};
        No150_逆波兰 n = new No150_逆波兰();
        int v = n.evalRPN(chars);
        System.out.println(v);
    }
}
