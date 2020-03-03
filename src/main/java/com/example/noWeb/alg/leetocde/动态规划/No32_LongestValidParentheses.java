package com.example.noWeb.alg.leetocde.动态规划;

import java.util.Stack;

public class No32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        //需有一个变量start记录有效括号子串的起始下标，max表示最长有效括号子串长度，初始值均为0
        int max = 0, start = 0;
        if (null == s || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < len; index++) {
            // 遇左括号（，压栈（栈中元素为当前位置所处的下标）
            if (s.charAt(index) == '(') {
                stack.push(index);
            } else {
                // 若栈为空，处理下一字符（当前字符右括号下标不入栈）
                if (stack.isEmpty()) {
                    start = index  ;  //max = Math.max(max, index - start+1  );
                } else {                    //若栈不为空，则出栈（由于仅左括号入栈，则出栈元素对应的字符一定为左括号，可与当前字符右括号配对），判断栈是否为空
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, index - start  );//max = Math.max(max, index - start+1  );
                    } else {
                        max = Math.max(max, index - stack.peek());
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        String s = "(()";
//        String s = ")()())";
        // todo 目前 22，26行代码有问题
        String s = "()";
        No32_LongestValidParentheses n = new No32_LongestValidParentheses();
        int max =  n.longestValidParentheses(s);
        System.out.println(max);
    }

}
