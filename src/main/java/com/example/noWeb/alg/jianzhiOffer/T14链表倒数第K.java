package com.example.noWeb.alg.jianzhiOffer;

import com.example.noWeb.alg.leetocde.ListNode;


public class T14链表倒数第K {
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head == null)
            return head;
        ListNode p = head;
        ListNode q;
        for(int i =0;i<k;i++){
            if(p==null)
                return null;
            p = p.next;
        }
        q = head;
        while (p!=null){
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
