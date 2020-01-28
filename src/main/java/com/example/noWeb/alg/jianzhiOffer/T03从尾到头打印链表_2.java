package com.example.noWeb.alg.jianzhiOffer;

import com.example.noWeb.alg.leetocde.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class T03从尾到头打印链表_2 {
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


    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead_1(ListNode listNode) {
        if(listNode!=null){
            this.printListFromTailToHead_1(listNode.next);
            res.add(listNode.val);
        }
        return res;

    }


}
