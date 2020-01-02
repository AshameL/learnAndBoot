package com.example.noWeb.alg.leetocde.链表专题;

import com.example.noWeb.alg.leetocde.ListNode;

public class No203_移除指定元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
