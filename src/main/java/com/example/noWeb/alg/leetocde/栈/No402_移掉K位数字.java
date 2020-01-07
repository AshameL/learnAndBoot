package com.example.noWeb.alg.leetocde.栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class No402_移掉K位数字 {
    public static String removeKdigits(String num, int k) {
        StringBuffer stack = new StringBuffer();
        int n = num.length();
        int m = n - k;
        if (n == k) return "0";
        for (char c : num.toCharArray()) {
            while ( stack.length()!=0  && k > 0 && stack.charAt(stack.length() - 1) > c) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(c);
        }
        stack = new StringBuffer(stack.substring(0, m));

        // 去掉0
        while (stack.length() != 0 && stack.charAt(0) == '0') {
            stack.deleteCharAt(0);
        }

        if (stack.length() == 0) {
            return "0";
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        String s = "1432219";
        int n = 3;
        String res = removeKdigits(s, n);
        System.out.println(res);
    }

}
