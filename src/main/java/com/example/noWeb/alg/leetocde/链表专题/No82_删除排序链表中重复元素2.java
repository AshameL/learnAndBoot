package com.example.noWeb.alg.leetocde.链表专题;

import com.example.noWeb.alg.leetocde.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class No82_删除排序链表中重复元素2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode p = head;
        HashSet<Integer> set = new HashSet<>();
        while (p != null && p.next != null) {
            ListNode bak = p.next;
            if (bak.val == p.val) {
                p.next = bak.next;
                set.add(p.val);
            } else {
                p = p.next;
            }
        }
        // 再开一遍
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        p = dummy;
        while (p.next != null) {
            if(set.contains(p.next.val)){
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        return dummy.next;

    }
}
