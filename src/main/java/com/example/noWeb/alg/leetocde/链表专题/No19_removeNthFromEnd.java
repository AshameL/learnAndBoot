package com.example.noWeb.alg.leetocde.链表专题;

import com.example.noWeb.alg.leetocde.ListNode;

public class No19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode H = new ListNode(0);
        H.next = head;
        ListNode fast = H,slow = H;
        while (fast!=null&&n!=0){
            fast = fast.next;
            n = n-1;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return H.next;
    }
}
