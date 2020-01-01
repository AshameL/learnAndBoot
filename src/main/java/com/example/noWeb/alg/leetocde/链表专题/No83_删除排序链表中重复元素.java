package com.example.noWeb.alg.leetocde.链表专题;

import com.example.noWeb.alg.leetocde.ListNode;

public class No83_删除排序链表中重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode p = head;
        ListNode bak = null;
        while (p.next != null) {
            bak = p.next;
            if (p.val == bak.val) {
                p.next = bak.next;
            }else {
                p = p.next;
            }
        }
        return head;
    }
}
