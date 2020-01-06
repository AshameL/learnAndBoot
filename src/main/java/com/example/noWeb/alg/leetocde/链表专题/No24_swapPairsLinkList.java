package com.example.noWeb.alg.leetocde.链表专题;

import com.example.noWeb.alg.leetocde.ListNode;

public class No24_swapPairsLinkList {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode tmp = pre;
        while(tmp.next!=null&&tmp.next.next!=null){
            ListNode start = tmp.next;
            ListNode end = tmp.next.next;

            // temp.next = end;
            // start.next = end.next;
            // end.next = start;
            // temp = start;

            tmp.next = end;
            start.next = end.next;
            end.next = start;

            tmp = tmp.next.next;

        }
        return pre.next;
    }

}
