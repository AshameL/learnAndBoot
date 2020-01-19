package com.example.noWeb.alg.jianzhiOffer;


import com.example.noWeb.alg.leetocde.ListNode;

public class T55删除链表中重复的结点 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode first = new ListNode(-1);
        first.next = pHead;

        ListNode p = pHead;
        ListNode last = first;
        while(p!=null&&p.next!=null){
            if(p.val==p.next.val){
                int val = p.val;
                while(p!=null&&p.val==val)
                    p=p.next;
                last.next = p;
            }else{
                last = p;
                p=p.next;
            }
        }
        return first.next;
    }
}