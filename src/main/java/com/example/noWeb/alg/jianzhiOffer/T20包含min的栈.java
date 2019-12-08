package com.example.noWeb.alg.jianzhiOffer;

import com.example.noWeb.alg.leetocde.ListNode;

import java.util.Stack;

/**

 */
public class T20包含min的栈 {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty()? node : Math.min(minStack.peek(),node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
