package com.example.noWeb.alg.jianzhiOffer;


import com.example.noWeb.alg.leetocde.ListNode;
import com.sun.org.apache.bcel.internal.generic.LNEG;

public class T36两个链表的第一个公共结点 {
    //通用解法
    public ListNode FindFirstCommonNode_common(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1,p2 = pHead2;
        int l1 = getLength(pHead1),l2 = getLength(pHead2);
        if(l1 < l2){
            p1 =pHead2;
            p2 = pHead1;
        }
        int cha = Math.abs(l1-l2);
        while(cha >0){
            cha--;
            p1 = p1.next;
        }
        while(p1!=null){
            if(p1==p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;

    }
    int getLength(ListNode head){
        int count = 0;
        while(head!=null){
            head = head.next;
            count++;
        }
        return count;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }
}