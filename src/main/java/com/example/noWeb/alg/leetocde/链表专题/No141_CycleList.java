package com.example.noWeb.alg.leetocde.链表专题;

import com.example.noWeb.alg.leetocde.ListNode;

public class No141_CycleList {
    public boolean hasCycle(ListNode head) {
        if( head==null ||head.next==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next !=null && fast.next.next!=null){
            if(slow==fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow==fast;
    }
}
