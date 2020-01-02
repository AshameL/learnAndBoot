package com.example.noWeb.alg.leetocde.链表专题;

import com.example.noWeb.alg.leetocde.ListNode;

import java.util.ArrayList;
import java.util.Stack;


public class No1290_二进制链表转整数 {
    public int getDecimalValue(ListNode head) {
        ListNode p = head;
        int ans = 0;
        while (p!= null){
            ans = ans*2+p.val;
            p = p.next;
        }

        return ans;
    }
}
