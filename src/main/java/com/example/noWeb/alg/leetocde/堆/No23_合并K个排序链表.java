package com.example.noWeb.alg.leetocde.堆;

import com.example.noWeb.alg.leetocde.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No23_合并K个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        PriorityQueue<ListNode> pq= new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode list:lists){
            if(list == null){
                continue;
            }
            pq.add(list);
        }

        while (!pq.isEmpty()){
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            curr = curr.next;
            //
            if(nextNode.next!=null){
                pq.add(nextNode.next);
            }
        }
        return  dummyHead.next;
    }
}
