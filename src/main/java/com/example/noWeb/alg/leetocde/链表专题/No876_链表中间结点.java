package com.example.noWeb.alg.leetocde.链表专题;

import com.example.noWeb.alg.leetocde.ListNode;

import java.util.HashSet;

public class No876_链表中间结点 {
    public ListNode middleNode(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 偶数
        if(fast.next==null){
            return slow.next;
        }else {
            return slow.next;
        }
    }

}
