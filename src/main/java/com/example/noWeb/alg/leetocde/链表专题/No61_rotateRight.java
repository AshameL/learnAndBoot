package com.example.noWeb.alg.leetocde.链表专题;

import com.example.noWeb.alg.leetocde.ListNode;

public class No61_rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        int len = 0;
        //计算长度 len
        while (p.next != null) {
            p = p.next;
            len++;
        }
        //取mod
        k = k%len;

        ListNode p1 = dummy;
        ListNode p2 = dummy;
        for(int i =0;i<k;i++){
            p1 = p1.next;
        }
        while (p1.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = dummy.next;
        dummy.next = p2.next;
        p2.next = null;

        return dummy.next;
    }
}
