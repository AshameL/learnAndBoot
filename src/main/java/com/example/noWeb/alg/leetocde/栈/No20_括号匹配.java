package com.example.noWeb.alg.leetocde.栈;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class No20_括号匹配 {
    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}'); put('[',']'); put('(',')'); put('?','?');
    }};
    public boolean isValid(String s) {
        if(s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        Stack<Character> stack = new Stack<>();
        stack.push('?');
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)) stack.push(c);
            else if(map.get(stack.pop()) != c) return false;
        }
        return stack.size() == 1;
    }

//    链接：https://leetcode-cn.com/problems/valid-parentheses/solution/valid-parentheses-fu-zhu-zhan-fa-by-jin407891080/

}
