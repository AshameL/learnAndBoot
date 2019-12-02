package com.example.noWeb.alg.jianzhiOffer;

import com.example.noWeb.alg.leetocde.ListNode;

/**

 */
public class T16合并排序的链表 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2==null)
            return list1;

        if(list1.val <= list2.val){
            list1.next = Merge(list1.next,list2);
            return list1;
        }
        else {
            list2.next = Merge(list1,list2.next);
            return list2;
        }
    }
}
