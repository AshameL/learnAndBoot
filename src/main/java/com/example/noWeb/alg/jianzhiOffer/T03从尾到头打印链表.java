package com.example.noWeb.alg.jianzhiOffer;

import com.example.noWeb.alg.leetocde.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class T03从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode p = listNode;
        Stack<Integer> stack = new Stack<>();
        while (p!=null){
            stack.push(p.val);
            p = p.next;
        }
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}
