package com.example.noWeb.alg.jianzhiOffer;

import java.util.Stack;

/**

 */
public class T21__栈的压入弹出序列 {
    public boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        for(int pushIndex=0,popIndex=0;pushIndex<n;pushIndex++){
            stack.push(pushSequence[pushIndex]);
            while (popIndex<n&&!stack.isEmpty()&& stack.peek()==popSequence[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
