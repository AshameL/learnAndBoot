package com.example.noWeb.alg.leetocde.栈;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class No232_用栈实现队列 {
    private Stack<Integer> a;// 输入栈
    private Stack<Integer> b;// 输出栈

    public void MyQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        a.push(x);
    }

    public int pop() {
        // 如果b栈为空，则将a栈全部弹出并压入b栈中，然后b.pop()
        if(b.isEmpty()){
            while(!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.pop();
    }

    public int peek() {
        if(b.isEmpty()){
            while(!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.peek();
    }

    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }

}
